package com.guitarshack

class Order(
  private val warehouse: Warehouse,
  val items: MutableList<Guitars> = mutableListOf(),
  var orderCost: Double = 0.0
) {
  fun addItem(guitar: Guitars) {
    items.add(guitar)
  }

  fun confirmOrder() {
    for (guitar in items) {
      if (warehouse.getStock(guitar) > 0) {
        warehouse.removeItem(guitar, 1)
      } else {
        throw IllegalStateException("Guitar $guitar is out of stock")
      }
    }
    calcTotalCost(items)
    items.clear()
  }

  private fun calcTotalCost(items: List<Guitars>) {
    val rawTotal = items.sumOf { it.price }
    orderCost = String.format("%.2f", rawTotal).toDouble()
  }
}


enum class Guitars(val price: Double, val weight: Double) {
    BEAST(999.99, 3.5),
    ELECTRIC_DREAM(1199.99, 3.2),
    MONSTER_RIFT(899.50, 4.0)
  }
