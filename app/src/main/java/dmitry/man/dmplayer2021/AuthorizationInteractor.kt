package dmitry.man.dmplayer2021

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class AuthorizationInteractor(private val dispatcher: CoroutineDispatcher) {

    suspend fun login(emailName: String, password: String): LoginResult =
        withContext(dispatcher) {
            delay(DELAY_MILLIS)
            when {
                emailName.isEmpty() -> LoginResult.Error.EmailName()
                password.isEmpty() -> LoginResult.Error.PasswordError.Empty()
                password.length < 6 -> LoginResult.Error.PasswordError.MinSix()
                //написать код проверки пароля с паролем на firebase
                // используя класс PasswordError.Wrong с последующей обработкой во View
                else -> LoginResult.Success()
            }
        }

    suspend fun registration(emailName: String, password: String): RegistrationResult =
        withContext(dispatcher) {
            delay(DELAY_MILLIS)
            when {
                emailName.isEmpty() -> RegistrationResult.Error.EmailName()
                password.isEmpty() -> RegistrationResult.Error.PasswordError.Empty()
                password.length < 6 -> RegistrationResult.Error.PasswordError.MinSix()
                else -> RegistrationResult.Success()
            }
        }

    companion object {
        const val DELAY_MILLIS: Long = 3_000
    }
}