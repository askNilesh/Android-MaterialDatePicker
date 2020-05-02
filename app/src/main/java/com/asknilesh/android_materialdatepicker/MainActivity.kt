package com.asknilesh.android_materialdatepicker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.AttrRes
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import java.util.*

import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowDatePicker.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            builder.setTitleText(R.string.title)

            val constraintsBuilder = CalendarConstraints.Builder()
            val calendar = Calendar.getInstance()
            val dateValidator = DateValidatorPointForward.from(calendar.timeInMillis)
            constraintsBuilder.setValidator(dateValidator)
            builder.setCalendarConstraints(constraintsBuilder.build())

            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener {
                // Get the offset from our timezone and UTC.
                val timeZoneUTC = TimeZone.getDefault()
                // It will be negative, so that's the -1
                val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1
                // Create a date format, then a date object with our offset
                val simpleFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                val date = Date(it + offsetFromUTC)
                tvResult.text = "Selected Date is " + simpleFormat.format(date)
            }
        }

        btnFullShowRangeDatePicker.setOnClickListener {
            val builder = MaterialDatePicker.Builder.dateRangePicker()

            val fullscreenTheme = getTheme(this, R.attr.materialCalendarFullscreenTheme)
            builder.setTheme(fullscreenTheme)

            val constraintsBuilder = CalendarConstraints.Builder()
            val calendar = Calendar.getInstance()
            val dateValidator = DateValidatorPointForward.from(calendar.timeInMillis)
            constraintsBuilder.setValidator(dateValidator)
            builder.setCalendarConstraints(constraintsBuilder.build())

            builder.setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener {

                val timeZoneUTC = TimeZone.getDefault()
                val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1

                val simpleFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                val startDate = it.first?.let { it1 -> Date(it1 + offsetFromUTC) }
                val endDate = it.second?.let { it1 -> Date(it1 + offsetFromUTC) }

                tvResult.text =
                    "Start Date " + simpleFormat.format(startDate) + "\nEnd Date " + simpleFormat.format(
                        endDate
                    )
            }
        }

        btnShowRangeDatePicker.setOnClickListener {
            val builder = MaterialDatePicker.Builder.dateRangePicker()

            val fullscreenTheme = getTheme(this, R.attr.materialCalendarTheme)
            builder.setTheme(fullscreenTheme)

            val constraintsBuilder = CalendarConstraints.Builder()
            val calendar = Calendar.getInstance()
            val dateValidator = DateValidatorPointForward.from(calendar.timeInMillis)
            constraintsBuilder.setValidator(dateValidator)
            builder.setCalendarConstraints(constraintsBuilder.build())

            builder.setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener {

                val timeZoneUTC = TimeZone.getDefault()
                val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1

                val simpleFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                val startDate = it.first?.let { it1 -> Date(it1 + offsetFromUTC) }
                val endDate = it.second?.let { it1 -> Date(it1 + offsetFromUTC) }

                tvResult.text =
                    "Start Date " + simpleFormat.format(startDate) + "\nEnd Date " + simpleFormat.format(
                        endDate
                    )
            }
        }
    }

    private fun getTheme(context: Context, @AttrRes attributeResId: Int): Int {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue.data
        }
        throw IllegalArgumentException(context.resources.getResourceName(attributeResId))
    }

}
