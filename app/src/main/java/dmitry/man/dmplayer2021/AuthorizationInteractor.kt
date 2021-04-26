package dmitry.man.dmplayer2021

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AuthorizationInteractor(private val dispatcher: CoroutineDispatcher) {

    suspend fun login(emailName: String, password: String): LoginResult =
        withContext(dispatcher) {
            when {
                emailName.isEmpty() -> LoginResult.Error.EmailName()
                password.isEmpty() -> LoginResult.Error.Password()
                else -> LoginResult.Success()
            }
        }

    suspend fun registration(emailName: String, password: String): RegistrationResult =
        withContext(dispatcher) {
            when {
                emailName.isEmpty() -> RegistrationResult.Error.EmailName()
                password.isEmpty() -> RegistrationResult.Error.Password()
                else -> RegistrationResult.Success()
            }
        }
}