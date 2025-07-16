package com.guitarshack

class Basket(
  val items: MutableList<Guitars> = mutableListOf()
) {
  fun addItem(guitar: Guitars) {
    items.add(guitar)
  }
}

enum class Guitars(val price: Double, val weight: Double) {
  BEAST(999.99, 3.5),
  ELECTRIC_DREAM(1199.99, 3.2),
  MONSTER_RIFT(899.50, 4.0)
}
