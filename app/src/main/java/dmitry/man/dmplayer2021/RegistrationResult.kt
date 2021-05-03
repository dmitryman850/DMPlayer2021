package dmitry.man.dmplayer2021

sealed class RegistrationResult {

    class Success : RegistrationResult()

    sealed class Error : RegistrationResult() {

        class EmailName : Error()

        sealed class PasswordError : Error() {

            class MinSix : PasswordError()

            class Empty : PasswordError()
        }
    }
}
