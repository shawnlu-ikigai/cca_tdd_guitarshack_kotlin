package com.guitarshack

class Order(
  private val warehouse: Warehouse,
  val items: MutableList<Guitars> = mutableListOf(),
  var orderCost: Double = 0.0
) {
  fun addItem(guitar: Guitars) {
    items.add(guitar)
  }

  fun confirmOrder(country: Country) {
    for (guitar in items) {
      if (warehouse.getStock(guitar) > 0) {
        warehouse.removeItem(guitar, 1)
      } else {
        throw IllegalStateException("Guitar $guitar is out of stock")
      }
    }
    calcTotalCost(items, country)
    items.clear()
  }

  private fun calcTotalCost(items: List<Guitars>, country: Country) {
    val rawTotal = items.sumOf { it.price }
    val shippingCost = Shipping().calculateForOrder(country.name, rawTotal)
    orderCost += shippingCost + rawTotal
  }
}
