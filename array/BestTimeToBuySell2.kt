// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0

        for(i in 1 until prices.size) {
            if(prices[i] > prices[i-1]) maxProfit += prices[i] - prices[i-1]
        }

        return maxProfit
}
