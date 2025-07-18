package com.guitarshack

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OrderTest {
  lateinit var warehouse: Warehouse
  lateinit var order: Order
  @BeforeEach
  fun init() {
    val initialStock = Guitars.values().associateWith { 100 }
    warehouse = Warehouse(HashMap(initialStock))
    order = Order(warehouse)
  }
    @Test
    fun shouldPass(){
        assertTrue(true);
    }

  @Test
  fun `should add item`(){
    assertTrue(order.items.isEmpty())
    order.addItem(Guitars.MONSTER_RIFT)
    assertEquals(1, order.items.size)
    assertEquals(Guitars.MONSTER_RIFT, order.items.get(0))
  }

  @Test
  fun `should update inventory`(){
    order.addItem(Guitars.MONSTER_RIFT)
    order.confirmOrder(Country.BELGIUM)
    assertEquals(99, warehouse.getStock(Guitars.MONSTER_RIFT))
  }

  @Test
  fun`should calculate shipping cost`(){
    order.addItem(Guitars.MONSTER_RIFT)
    order.addItem(Guitars.ELECTRIC_DREAM)
    order.addItem(Guitars.BEAST)
    order.confirmOrder(Country.BELGIUM)
    val orderCost = order.orderCost
    assertEquals(3109.47, orderCost, 0.01)
  }
}