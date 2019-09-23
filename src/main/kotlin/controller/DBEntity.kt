package controller

class DBEntity(private val id: Long, private var nickname: String, private var fullname: String) {
    init {
        println(toString())
    }

    override fun toString(): String = "{id: $id, nickname: $nickname, fullname: $fullname}"
}