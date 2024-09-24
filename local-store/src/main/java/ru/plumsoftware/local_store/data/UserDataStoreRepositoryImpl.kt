package ru.plumsoftware.local_store.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.plumsoftware.domain.model.User
import ru.plumsoftware.local_store.domain.UserDataStoreRepository
import ru.plumsoftware.local_store.user_data_store.Constants

class UserDataStoreRepositoryImpl(private val dataStore: DataStore<Preferences>) :
    UserDataStoreRepository {
    override suspend fun editUserData(user: User) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(Constants.DATA_STORE_USER_THEME_MODE)] = user.theme
        }
    }

    override fun getUserData(): Flow<User> {
        return dataStore.data.map { preferences ->
            val theme =
                preferences[booleanPreferencesKey(Constants.DATA_STORE_USER_THEME_MODE)] ?: false
            return@map User(theme = theme)
        }
    }

    override suspend fun editThemeMode(theme: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(Constants.DATA_STORE_USER_THEME_MODE)] = theme
        }
    }
}