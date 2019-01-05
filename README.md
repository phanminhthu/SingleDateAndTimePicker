# SingleDateAndTimePicker
<img src="https://raw.githubusercontent.com/tusinh/SingleDateAndTimePicker/master/image.png" width="200" height="300"/>

# How to use
* use like your module lib android
1. init :
```java
 SingleDateAndTimePickerDialog.Builder singleBuilder;
```
2. create and show 
```java
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(currentDateandTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        final Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH, 10);
//        calendar.set(Calendar.MONTH, 1);
//        calendar.set(Calendar.YEAR, 2014);
//        calendar.set(Calendar.HOUR_OF_DAY, 12);
//        calendar.set(Calendar.MINUTE, 13);
//
//        final Date defaultDate = calendar.getTime();

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        final SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        singleBuilder = new SingleDateAndTimePickerDialog.Builder(MainActivity.this)
                .bottomSheet()
                .curved()

                //.backgroundColor(Color.BLACK)
                .mainColor(getResources().getColor(R.color.colorAccent))

                .displayHours(false)
                .displayMinutes(false)
                .displayDays(false)

                .displayMonth(true)
                .displayDaysOfMonth(true)
                .displayYears(true)
                .displayMonthNumbers(true)

                //.mustBeOnFuture()

                //.minutesStep(15)
                //.mustBeOnFuture()
                .defaultDate(dateObj)
                // .minDateRange(minDate)
                // .maxDateRange(maxDate)

                .displayListener(new SingleDateAndTimePickerDialog.DisplayListener() {
                    @Override
                    public void onDisplayed(SingleDateAndTimePicker picker) {

                    }
                })
                .title("Hủy")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {

                        tvdate.setText(simpleDateFormat.format(date));

                    }
                });
        singleBuilder.display();
```

