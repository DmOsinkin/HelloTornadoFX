package view

import javafx.collections.FXCollections
import tornadofx.*

class MyView : View() {
    val controller: view.MyController by inject()

    override val root = vbox {
        label("My items")
        listview(controller.values)
    }
}

class MyController: Controller() {
    val values = FXCollections.observableArrayList("Alpha","Beta","Gamma","Delta")
}