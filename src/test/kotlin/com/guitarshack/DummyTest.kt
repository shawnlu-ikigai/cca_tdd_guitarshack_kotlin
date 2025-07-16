package com.guitarshack

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DummyTest {
  lateinit var inventory: Inventory
  @BeforeEach
  fun init() {
    val initialStock = Guitars.values().associateWith { 100 }
    inventory = Inventory(HashMap(initialStock))
  }
    @Test
    fun shouldPass(){
        assertTrue(true);
    }

  @Test
  fun `should add item`(){
    val basket = Basket(inventory)
    assertTrue(basket.items.isEmpty())
    basket.addItem(Guitars.MONSTER_RIFT)
    assertEquals(1, basket.items.size)
    assertEquals(Guitars.MONSTER_RIFT, basket.items.get(0))
    basket.confirmOrder()
    assertEquals(99, inventory.getStock(Guitars.MONSTER_RIFT))
  }
}