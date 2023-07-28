package com.designlife.aislefeature.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.designlife.aislefeature.R
import com.designlife.aislefeature.common.utils.AppServiceLocator
import com.designlife.aislefeature.common.utils.Constants
import com.designlife.aislefeature.home.domain.entities.ProfileData
import com.designlife.aislefeature.home.presentation.components.BottomNavigationBar
import com.designlife.aislefeature.home.presentation.components.NotesComponent
import com.designlife.aislefeature.home.presentation.components.PremiumUpgradeComponent
import com.designlife.aislefeature.home.presentation.components.RecommendedProfile
import com.designlife.aislefeature.home.presentation.components.SayHiComponent
import com.designlife.aislefeature.home.presentation.components.TopNotesComponent
import com.designlife.aislefeature.home.presentation.helper.BottomNavItem
import com.designlife.aislefeature.home.presentation.helper.ScreenType
import com.designlife.aislefeature.home.presentation.viewmodel.HomeViewModel
import com.designlife.aislefeature.home.presentation.viewmodel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var navigationItems : List<BottomNavItem>
    private lateinit var viewmodel : HomeViewModel
    private var args : Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigationItems = listOf<BottomNavItem>(
            BottomNavItem("Discover",R.drawable.ic_discover),
            BottomNavItem("Notes",R.drawable.ic_notes),
            BottomNavItem("Matches",R.drawable.ic_matches),
            BottomNavItem("Profile",R.drawable.ic_profile)
        )

        val notesRepository = AppServiceLocator.provideNotesRepository(requireActivity().application)
        val factory = HomeViewModelFactory(notesRepository)
        viewmodel = ViewModelProvider(this,factory)[HomeViewModel::class.java]

        // set token
        args = arguments
        args?.let {bundle ->
            val token = bundle.getString(Constants.TOKEN)
            token?.let {
                viewmodel.onEvent(HomeEvents.OnTokenUpdate(it))
            }
        }
        if (viewmodel.token.value.isNotEmpty()){
            viewmodel.initiateDataRequest()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireActivity()).apply {
            setContent {
                val selectedScreenType = viewmodel.selectedScreenItemType.value
                val topNoteBanner = if (viewmodel.topNotes.value.isNotEmpty()) viewmodel.topNotes.value[0] else ProfileData.TopNotes()
                val likedProfile = viewmodel.likedProfiles.value

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        when(selectedScreenType){
                            ScreenType.DISCOVER -> {
                                SayHiComponent(message = "Discover")
                            }
                            ScreenType.NOTES -> {
                                LazyColumn(
                                    modifier = Modifier.fillMaxSize()
                                ){
                                    item {
                                        NotesComponent()
                                        Spacer(modifier = Modifier.height(16.dp))
                                        TopNotesComponent(
                                            topNotes = topNoteBanner
                                        ) {

                                        }
                                    }
                                    item {
                                        Spacer(modifier = Modifier.height(12.dp))
                                        PremiumUpgradeComponent {

                                        }
                                        Spacer(modifier = Modifier.height(12.dp))
                                    }
                                    items(likedProfile.size){ index ->
                                        val pairList = likedProfile[index]
                                        if (pairList.isNotEmpty()){
                                            Row(modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 16.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                if (pairList.size == 2){
                                                    val first = pairList[0]
                                                    val second = pairList[1]
                                                    RecommendedProfile(avatar = first.avatar ?: "", name = first.firstName ?: "")
                                                    RecommendedProfile(avatar = second.avatar ?: "", name = second.firstName ?: "")
                                                }else{
                                                    val first = pairList[0]
                                                    RecommendedProfile(avatar = first.avatar ?: "", name = first.firstName ?: "")
                                                }

                                            }
                                        }
                                    }
                                    item {
                                        Spacer(modifier = Modifier.height(80.dp))
                                    }
                                }

                            }
                            ScreenType.MATCHES -> {
                                SayHiComponent(message = "Find Matches")
                            }
                            ScreenType.PROFILE -> {
                                SayHiComponent(message = "Check Profile")
                            }
                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        BottomNavigationBar(items = navigationItems, selectedScreen = selectedScreenType) {
                            viewmodel.onEvent(HomeEvents.OnItemSelected(it))
                        }
                    }
                }
            }
        }
    }
}