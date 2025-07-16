package com.guitarshack

class Basket(
  private val inventory: Inventory,
  val items: MutableList<Guitars> = mutableListOf()
) {
  fun addItem(guitar: Guitars) {
    items.add(guitar)
  }

  fun confirmOrder() {
    for (guitar in items) {
      if (inventory.getStock(guitar) > 0) {
        inventory.removeItem(guitar, 1)
      } else {
        throw IllegalStateException("Guitar $guitar is out of stock")
      }
    }
    items.clear()
  }
}


enum class Guitars(val price: Double, val weight: Double) {
    BEAST(999.99, 3.5),
    ELECTRIC_DREAM(1199.99, 3.2),
    MONSTER_RIFT(899.50, 4.0)
  }
