package com.tb.test.utils.url

/**
 * This class responsible to fix broken urls.
 */
interface SafeUrl {

    /**
     * This method try to fix broken urls. The method must fix the issues only, if there is no issue with
     * the url returns with the original url.
     *
     * Known issues:
     * * Double forward slash
     * * Clear text call
     *
     *  @param url the target url
     *  @return The fixed url if it contains any issue, the original if it not contains any issue.
     */
    fun makeUrlSafe(url: String): String

}