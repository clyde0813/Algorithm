class Solution {
    fun solution(myString: String): String {
        val sb = StringBuilder()
        
        for(c in myString.toCharArray()) {
            sb.append(if (c.code > 108) c else 'l')
        }
        
        return sb.toString()
    }
}