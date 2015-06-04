package com.ejrope.samples.snackbarsample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SnackbarSampleActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.snackbar_sample_activity);

    Button btnSimpleSnackbar = (Button) findViewById(R.id.btnSimpleSnackbar);
    btnSimpleSnackbar.setOnClickListener(myOnClickSimpleSnackbar);

    Button btnSnackbarWithAction = (Button) findViewById(R.id.btnSnackbarWithAction);
    btnSnackbarWithAction.setOnClickListener(myOnClickSnackbarWithAction);

    Button btnSnackbarLongDuration = (Button) findViewById(R.id.btnSnackbarLongDuration);
    btnSnackbarLongDuration.setOnClickListener(myOnClickSnackbarLongDuration);

    Button btnSnackbarAlternativeBackgroundColor =
        (Button) findViewById(R.id.btnSnackbarAlternativeBackgroundColor);
    btnSnackbarAlternativeBackgroundColor.setOnClickListener(myOnClickSnackbarAlternativeBackgroundColor);

    Button btnSnackbarAlternativeTextColor =
        (Button) findViewById(R.id.btnSnackbarAlternativeTextColor);
    btnSnackbarAlternativeTextColor.setOnClickListener(myOnClickSnackbarAlternativeTextColor);
  }

  private View.OnClickListener myOnClickSimpleSnackbar = new View.OnClickListener() {
    @Override public void onClick(View view) {
      Snackbar.make(view, R.string.simple_snackbar, Snackbar.LENGTH_SHORT).show();
    }
  };

  private View.OnClickListener myOnClickSnackbarWithAction = new View.OnClickListener() {
    @Override public void onClick(View view) {
      Snackbar.make(view, R.string.snackbar_with_action, Snackbar.LENGTH_SHORT)
          .setAction(getString(R.string.snackbar_action), myOnClickSnackbarAction)
          .setActionTextColor(getResources().getColor(R.color.snackbar_action))
          .show();
    }
  };

  private View.OnClickListener myOnClickSnackbarAction = new View.OnClickListener() {
    @Override public void onClick(View view) {
      Toast.makeText(view.getContext(), getString(R.string.onclick_snackbar_action),
          Toast.LENGTH_SHORT).show();
    }
  };

  private View.OnClickListener myOnClickSnackbarLongDuration = new View.OnClickListener() {
    @Override public void onClick(View view) {
      Snackbar.make(view, R.string.snackbar_long_duration, Snackbar.LENGTH_LONG).show();
    }
  };

  private View.OnClickListener myOnClickSnackbarAlternativeBackgroundColor =
      new View.OnClickListener() {
        @Override public void onClick(View view) {
          Snackbar snackbar =
              Snackbar.make(view, R.string.snackbar_backgroundcolor, Snackbar.LENGTH_SHORT);

          // Get snackbar's view and change background color
          View snackbarView = snackbar.getView();
          snackbarView.setBackgroundColor(
              getResources().getColor(R.color.snackbar_alternative_background));
          snackbar.show();
        }
      };

  private View.OnClickListener myOnClickSnackbarAlternativeTextColor = new View.OnClickListener() {
    @Override public void onClick(View view) {
      Snackbar snackbar = Snackbar.make(view, R.string.snackbar_textcolor, Snackbar.LENGTH_SHORT);

      // Get snackbar's textView and change text color
      TextView snackbarTextView =
          (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
      snackbarTextView.setTextColor(getResources().getColor(R.color.snackbar_alternative_text));
      snackbar.show();
    }
  };

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
