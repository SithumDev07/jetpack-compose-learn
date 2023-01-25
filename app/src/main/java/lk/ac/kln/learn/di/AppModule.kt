package lk.ac.kln.learn.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lk.ac.kln.learn.data.AppDatabase
import lk.ac.kln.learn.data.ItemDao
import lk.ac.kln.learn.repository.ItemRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideItemRepository(itemDao: ItemDao): ItemRepository {
        return ItemRepository(itemDao)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase {
        return AppDatabase.getInstance(context = app)
    }

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: AppDatabase): ItemDao{
        return appDatabase.itemDao()
    }

}