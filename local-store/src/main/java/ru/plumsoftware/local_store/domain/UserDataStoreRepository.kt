package ru.plumsoftware.local_store.domain

import kotlinx.coroutines.flow.Flow
import ru.plumsoftware.domain.model.User

interface UserDataStoreRepository {
    suspend fun editUserData(user: User)
    fun getUserData() : Flow<User>
    suspend fun editThemeMode(theme: Boolean)
}