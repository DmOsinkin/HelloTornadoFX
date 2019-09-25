package view

import controller.DBEntity
import tornadofx.*

class MainView : View() {

    val dBcontroller = controller.DBController()

    override val root = tabpane {
        setMinSize(600.0,400.0)

        tab("All entities") {
            runAsync {
                dBcontroller.getAll().asObservable()
            } ui { loadedList ->
                tableview(loadedList) {
                    readonlyColumn("#", DBEntity::id)
                    readonlyColumn("Number", DBEntity::nickname)
                    readonlyColumn("Type", DBEntity::fullname)

                    smartResize()
                }
            }

        }
        tab("test") {
            hbox {
                button("Button 3")
                button("Button 4")
            }
        }
    }
}