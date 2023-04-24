package com.example.dataStructure

import java.security.MessageDigest
import java.nio.charset.StandardCharsets

class encriptado {
    companion object {
        fun encryptToMD5(message: String): String {
            val md = MessageDigest.getInstance("MD5")
            val hash = md.digest(message.toByteArray(StandardCharsets.UTF_8))
            val hexString = StringBuilder()

            for (b in hash) {
                val hex = Integer.toHexString(0xff and b.toInt())
                if (hex.length == 1) hexString.append('0')
                hexString.append(hex)
            }

            return hexString.toString()
        }
    }
}
