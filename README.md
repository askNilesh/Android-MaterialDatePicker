

# Android-MaterialDatePicker

in this repository i will guide you step by step guide on how to use the new Material Date Picker in android

## Follow below steps

Step 1: Add dependency in build.gradle (app) file


```bash
implementation 'com.google.android.material:material:1.2.0-alpha06'
```


Step 2: Change your app theme


```bash 
<style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
</style>
```

Step 3: Initialise the Material date picker builder
```bash
val builder = MaterialDatePicker.Builder.datePicker()
```

Step 4: show the Material date picker builder
```bash
val picker = builder.build()
picker.show(supportFragmentManager, picker.toString())
```

Step 4 : Add ClickListener to your MaterialDatePicker
```bash
 picker.addOnPositiveButtonClickListener { 
                
 }
 picker.addOnNegativeButtonClickListener { 
                
 }

```

Step 5 : Get selected date from MaterialDatePicker
```bash
 picker.addOnPositiveButtonClickListener {
         
       val timeZoneUTC = TimeZone.getDefault()
       val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1
       val simpleFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
       val date = Date(it + offsetFromUTC)
       tvResult.text = "Selected Date is " + simpleFormat.format(date)

}

```




## © License 
```
MIT License

Copyright (c) 2020 Nilesh Rathod

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
