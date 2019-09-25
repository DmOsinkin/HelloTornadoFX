package controller

import tornadofx.Controller
import java.io.File

class DBController() : Controller() {
    var dbFile: File = File("./build/resources/main/db.txt")

    fun getAll(): List<DBEntity> {
        val preparingEntities: List<String> = dbFile.bufferedReader().readLines()
        val entityList: ArrayList<DBEntity> = ArrayList(0)
        for (line: String in preparingEntities) {
            val entity = line.split(";").toDBEntity()
            entityList.add(entity as DBEntity)
        }
        return entityList
    }

    fun getById(id: Long): DBEntity? {
        val entityList = getAll()
        entityList.forEach { dbEntity: DBEntity ->
            if(dbEntity.id == id) return dbEntity
        }
        return null
    }

    fun add(dbEntity: DBEntity) {
        dbFile.bufferedWriter().use { out -> out.append(dbEntity.toString()) }
    }


}

private fun <E> List<E>.toDBEntity(): Any {
    val id: Long = this[0].toString().toLong()
    val nickname: String = this[1].toString()
    val fullname: String = this[2].toString()
    val entity = DBEntity(id, nickname, fullname)
    return entity
}
