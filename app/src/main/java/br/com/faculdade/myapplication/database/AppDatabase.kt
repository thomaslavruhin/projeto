package br.com.faculdade.myapplication.database

import androidx.room.*
import br.com.faculdade.myapplication.database.entity.SupportDto
import br.com.faculdade.myapplication.database.entity.UserDto

@Database(entities = [
    UserDto::class,
    SupportDto::class
], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun supportDao() : SupportDao
}

@Dao
interface UserDao {

    @Query( "SELECT * FROM userdto")
    fun fetchCustomers(): List<UserDto>
}

@Dao
interface SupportDao {

    @Query( "SELECT * FROM SupportDto")
    fun fetchSupport(): List<SupportDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSupport(supportDto: SupportDto): Long

}