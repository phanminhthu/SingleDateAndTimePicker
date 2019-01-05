package timepicker.test.com.testsingledateandtimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import timepicker.test.com.testsingledateandtimepicker.singledateandtimepicker.SingleDateAndTimePicker;
import timepicker.test.com.testsingledateandtimepicker.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView tvdate;
    SingleDateAndTimePickerDialog.Builder singleBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        tvdate = findViewById(R.id.tvdate);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectDate();
            }
        });

    }
    private void SelectDate() {

//        String dateStr = "20/12/2018";
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
    }
}
