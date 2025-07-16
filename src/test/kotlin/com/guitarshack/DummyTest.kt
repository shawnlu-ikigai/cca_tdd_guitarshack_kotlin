package com.guitarshack

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DummyTest {
  lateinit var inventory: Inventory
  lateinit var basket: Basket
  @BeforeEach
  fun init() {
    val initialStock = Guitars.values().associateWith { 100 }
    inventory = Inventory(HashMap(initialStock))
    basket = Basket(inventory)
  }
    @Test
    fun shouldPass(){
        assertTrue(true);
    }

  @Test
  fun `should add item`(){
    assertTrue(basket.items.isEmpty())
    basket.addItem(Guitars.MONSTER_RIFT)
    assertEquals(1, basket.items.size)
    assertEquals(Guitars.MONSTER_RIFT, basket.items.get(0))
  }

  @Test
  fun `should update inventory`(){
    basket.addItem(Guitars.MONSTER_RIFT)
    basket.confirmOrder()
    assertEquals(99, inventory.getStock(Guitars.MONSTER_RIFT))
  }

  @Test
  fun`should calculate shipping cost`(){
    basket.addItem(Guitars.MONSTER_RIFT)
    basket.addItem(Guitars.ELECTRIC_DREAM)
    basket.addItem(Guitars.BEAST)
    basket.confirmOrder()
    val orderCost = basket.orderCost
    assertEquals(3099.48, orderCost)
    val shipingCost = Shipping().calculateForOrder("Belgium",orderCost)
    assertEquals(4.99, shipingCost)
  }
}