package controller

import tornadofx.Controller
import java.io.File

class DBController: Controller() {

    private val dbFile: File = File("db.txt")

    fun getAll(): List<DBEntity> {
        val preparingEntities: List<String> = dbFile.bufferedReader().readLines()
        var entityList: ArrayList<DBEntity> = ArrayList(0)
        for (line: String in preparingEntities) {
            var entity = line.split(";").toDBEntity()
            entityList.add(entity as DBEntity)
        }
        return entityList
    }

    fun getById(id: Long) {

    }



}

private fun <E> List<E>.toDBEntity(): Any {
    var id: Long = this[0].toString().toLong()
    var nickname: String = this[1].toString()
    var fullname: String = this[2].toString()
    var entity = DBEntity(id, nickname, fullname)
    return entity
}
