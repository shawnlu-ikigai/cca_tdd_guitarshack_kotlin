package com.guitarshack

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DummyTest {
    @Test
    fun shouldPass(){
        assertTrue(true);
    }

  @Test
  fun `should add item`(){
    val basket = Basket()
    assertTrue(basket.items.isEmpty())
    basket.addItem(Guitars.MONSTER_RIFT)
    assertEquals(1, basket.items.size)
    assertEquals(Guitars.MONSTER_RIFT, basket.items.get(0))
  }
}