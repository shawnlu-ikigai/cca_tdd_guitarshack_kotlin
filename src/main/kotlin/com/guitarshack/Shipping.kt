import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject

class Shipping {

    fun calculateForOrder(country: String, orderTotal: Double): Double {
        val urlString = "https://npovmrfcyzu2gu42pmqa7zce6a0zikbf.lambda-url.eu-west-2.on.aws/?country=$country"
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"

        if (connection.responseCode != HttpURLConnection.HTTP_OK) {
            throw RuntimeException("HTTP GET Request Failed with Error code : ${connection.responseCode}")
        }

        val response = connection.inputStream.bufferedReader().use { it.readText() }
        val region = JSONObject(response).getString("region")

        var shipping = 0.0

        when (region) {
            "UK" -> {
                if (orderTotal < 100.0) {
                    shipping = 4.99
                }
            }
            "EU" -> {
                shipping = if (orderTotal < 100.0) {
                    8.99
                } else {
                    4.99
                }
            }
            "OTHER" -> {
                shipping = 9.99
            }
        }

        connection.disconnect()
        return shipping
    }
}
