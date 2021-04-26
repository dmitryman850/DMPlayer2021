package dmitry.man.dmplayer2021

sealed class LoginResult {

    class Success : LoginResult()

    sealed class Error : LoginResult() {

        class EmailName : Error()

        class Password : Error()
    }
}
