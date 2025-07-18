package com.guitarshack

class Order(
  private val warehouse: Warehouse,
  val items: MutableList<Guitars> = mutableListOf(),
  var orderCost: Double = 0.0
) {
  fun addItem(guitar: Guitars) {
    warehouse.deductStock(guitar, 1)
    items.add(guitar)
  }

  fun confirmOrder(country: Country) {
    calcTotalCost(items, country)
    items.clear()
  }

  private fun calcTotalCost(items: List<Guitars>, country: Country) {
    val rawTotal = items.sumOf { it.price }
    val shippingCost = Shipping().calculateForOrder(country.name, rawTotal)
    orderCost += shippingCost + rawTotal
  }
}
