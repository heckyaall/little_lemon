package com.courseapp.littlelemonforyou.data

sealed class OnBoardAction {
    data class FirstNameChanged(val firstName: String) : OnBoardAction()
    data class LastNameChanged(val lastName: String) : OnBoardAction()
    data class EmailChanged(val email: String) : OnBoardAction()

}