package com.ayn.cvcreater.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.view.View
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun bitmapFromView(view: View): Bitmap {
    val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.RGB_565)
    val canvas = Canvas(bitmap)
    view.layout(view.left, view.top, view.right, view.bottom)
    view.draw(canvas)
    return bitmap
}

fun shareImageUri(context: Context, uri: Uri) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.putExtra(Intent.EXTRA_STREAM, uri)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    intent.type = "image/png"
    context.startActivity(intent)
}

fun saveBitmapToCache(context: Context): Uri? {
    return try {
        val imagesFolder = File(context.cacheDir, "images")
        imagesFolder.mkdirs()
        val file = File(imagesFolder, "share.pdf")
        return FileProvider.getUriForFile(context, "com.ayn.cvcreater.fileProvider", file)
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}

fun convertToPdf(context: Context,bitmap: Bitmap){
    val imagesFolder = File(context.cacheDir, "images")
    val document = PdfDocument()
    val pageInfo: PdfDocument.PageInfo  = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, 1).create()
    val page: PdfDocument.Page  = document.startPage(pageInfo)

    val canvas: Canvas = page.canvas
    canvas.drawBitmap(bitmap, 0f, 0f, null)
    document.finishPage(page)

    val file = File(imagesFolder, "share.pdf")
    document.writeTo( FileOutputStream(file))
    document.close()
}

