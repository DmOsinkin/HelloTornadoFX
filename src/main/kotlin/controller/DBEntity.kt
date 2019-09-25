package controller

class DBEntity(val id: Long, var nickname: String, var fullname: String) {
    init {
        println(toString())
    }

    override fun toString(): String = "$id;$nickname;$fullname"
}