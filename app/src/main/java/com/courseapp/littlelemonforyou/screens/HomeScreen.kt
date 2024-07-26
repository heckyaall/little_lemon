package com.courseapp.littlelemonforyou.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.courseapp.littlelemonforyou.AppViewModel
import com.courseapp.littlelemonforyou.appcomponents.Header
import com.courseapp.littlelemonforyou.appcomponents.LowerPanel
import com.courseapp.littlelemonforyou.appcomponents.UpperPanel

@Composable
fun HomeScreen( navController: NavHostController){
    val appViewModel: AppViewModel = viewModel()
    val databaseMenuItems = appViewModel.getAllDatabaseMenuItems().observeAsState(emptyList()).value
    val searchPhrase = remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit){
        appViewModel.fetchMenuDataFromDatabase()
    }
    Column {
        Header(navController)
        UpperPanel { searchPhrase.value = it }
        LowerPanel(databaseMenuItems = databaseMenuItems, search = searchPhrase)

            }
}
