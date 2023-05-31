package ni.edu.uca.sistematicopersistencia.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto

@Dao
interface ProductoDao {
    @Query("SELECT * FROM TblProducto")
    suspend fun obtenerProducto(): MutableList<EntityProducto>

    @Insert
    suspend fun agregarProducto(entityProducto: EntityProducto)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarReg(producto: EntityProducto)

    @Update
    suspend fun actualizarReg(producto: EntityProducto)

    @Delete
    suspend fun eliminarReg(producto: EntityProducto)

}