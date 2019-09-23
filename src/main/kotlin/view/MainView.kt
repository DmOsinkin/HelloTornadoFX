package view

import tornadofx.*

class MainView : View() {
    override val root = tabpane {
        setMinSize(600.0,400.0)

        tab("All entities") {
            vbox {
                button("Button 1")
                button("Button 2")
            }
        }
        tab("") {
            hbox {
                button("Button 3")
                button("Button 4")
            }
        }
    }
}