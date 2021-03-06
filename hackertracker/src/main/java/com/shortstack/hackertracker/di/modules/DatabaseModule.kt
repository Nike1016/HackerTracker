package com.shortstack.hackertracker.di.modules

import android.content.Context
import com.shortstack.hackertracker.database.DatabaseManager
import com.shortstack.hackertracker.di.MyApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by Chris on 5/21/2018.
 */
@Module
class DatabaseModule {

    @Provides
    @Inject
    @MyApplicationScope
    fun provideDatabase(context: Context) = DatabaseManager(context)
}