// Generated by view binder compiler. Do not edit!
package com.example.gymapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gymapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWorkoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView backBtn;

  @NonNull
  public final AppCompatButton buttonStart;

  @NonNull
  public final TextView descriptionTxt;

  @NonNull
  public final TextView durationTxt;

  @NonNull
  public final TextView exerciseTxt;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final TextView kcalTxt;

  @NonNull
  public final ImageView pic2;

  @NonNull
  public final ScrollView scrollView3;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final TextView titleTxt;

  @NonNull
  public final View view;

  @NonNull
  public final RecyclerView view3;

  @NonNull
  public final ConstraintLayout workoutPage;

  private ActivityWorkoutBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView backBtn,
      @NonNull AppCompatButton buttonStart, @NonNull TextView descriptionTxt,
      @NonNull TextView durationTxt, @NonNull TextView exerciseTxt, @NonNull ImageView imageView7,
      @NonNull TextView kcalTxt, @NonNull ImageView pic2, @NonNull ScrollView scrollView3,
      @NonNull TextView textView14, @NonNull TextView textView15, @NonNull TextView textView17,
      @NonNull TextView textView20, @NonNull TextView titleTxt, @NonNull View view,
      @NonNull RecyclerView view3, @NonNull ConstraintLayout workoutPage) {
    this.rootView = rootView;
    this.backBtn = backBtn;
    this.buttonStart = buttonStart;
    this.descriptionTxt = descriptionTxt;
    this.durationTxt = durationTxt;
    this.exerciseTxt = exerciseTxt;
    this.imageView7 = imageView7;
    this.kcalTxt = kcalTxt;
    this.pic2 = pic2;
    this.scrollView3 = scrollView3;
    this.textView14 = textView14;
    this.textView15 = textView15;
    this.textView17 = textView17;
    this.textView20 = textView20;
    this.titleTxt = titleTxt;
    this.view = view;
    this.view3 = view3;
    this.workoutPage = workoutPage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWorkoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWorkoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_workout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWorkoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backBtn;
      ImageView backBtn = ViewBindings.findChildViewById(rootView, id);
      if (backBtn == null) {
        break missingId;
      }

      id = R.id.buttonStart;
      AppCompatButton buttonStart = ViewBindings.findChildViewById(rootView, id);
      if (buttonStart == null) {
        break missingId;
      }

      id = R.id.descriptionTxt;
      TextView descriptionTxt = ViewBindings.findChildViewById(rootView, id);
      if (descriptionTxt == null) {
        break missingId;
      }

      id = R.id.durationTxt;
      TextView durationTxt = ViewBindings.findChildViewById(rootView, id);
      if (durationTxt == null) {
        break missingId;
      }

      id = R.id.exerciseTxt;
      TextView exerciseTxt = ViewBindings.findChildViewById(rootView, id);
      if (exerciseTxt == null) {
        break missingId;
      }

      id = R.id.imageView7;
      ImageView imageView7 = ViewBindings.findChildViewById(rootView, id);
      if (imageView7 == null) {
        break missingId;
      }

      id = R.id.kcalTxt;
      TextView kcalTxt = ViewBindings.findChildViewById(rootView, id);
      if (kcalTxt == null) {
        break missingId;
      }

      id = R.id.pic2;
      ImageView pic2 = ViewBindings.findChildViewById(rootView, id);
      if (pic2 == null) {
        break missingId;
      }

      id = R.id.scrollView3;
      ScrollView scrollView3 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView3 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView20;
      TextView textView20 = ViewBindings.findChildViewById(rootView, id);
      if (textView20 == null) {
        break missingId;
      }

      id = R.id.titleTxt;
      TextView titleTxt = ViewBindings.findChildViewById(rootView, id);
      if (titleTxt == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      id = R.id.view3;
      RecyclerView view3 = ViewBindings.findChildViewById(rootView, id);
      if (view3 == null) {
        break missingId;
      }

      ConstraintLayout workoutPage = (ConstraintLayout) rootView;

      return new ActivityWorkoutBinding((ConstraintLayout) rootView, backBtn, buttonStart,
          descriptionTxt, durationTxt, exerciseTxt, imageView7, kcalTxt, pic2, scrollView3,
          textView14, textView15, textView17, textView20, titleTxt, view, view3, workoutPage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
