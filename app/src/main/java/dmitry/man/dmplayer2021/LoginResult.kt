package dmitry.man.dmplayer2021

sealed class LoginResult {

    class Success : LoginResult()

    sealed class Error : LoginResult() {

        class EmailName : Error()

        sealed class PasswordError : Error() {

            class MinSix : PasswordError()

            class Empty : PasswordError()

            class Wrong : PasswordError()
        }
    }
}
