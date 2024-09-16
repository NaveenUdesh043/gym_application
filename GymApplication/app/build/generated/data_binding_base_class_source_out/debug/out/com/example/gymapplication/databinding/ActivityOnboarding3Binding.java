// Generated by view binder compiler. Do not edit!
package com.example.gymapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gymapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOnboarding3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final AppCompatButton nextBtn;

  @NonNull
  public final ConstraintLayout onboarding3;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView16;

  private ActivityOnboarding3Binding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView6, @NonNull AppCompatButton nextBtn,
      @NonNull ConstraintLayout onboarding3, @NonNull TextView textView13,
      @NonNull TextView textView16) {
    this.rootView = rootView;
    this.imageView6 = imageView6;
    this.nextBtn = nextBtn;
    this.onboarding3 = onboarding3;
    this.textView13 = textView13;
    this.textView16 = textView16;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOnboarding3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOnboarding3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_onboarding3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOnboarding3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView6;
      ImageView imageView6 = ViewBindings.findChildViewById(rootView, id);
      if (imageView6 == null) {
        break missingId;
      }

      id = R.id.nextBtn;
      AppCompatButton nextBtn = ViewBindings.findChildViewById(rootView, id);
      if (nextBtn == null) {
        break missingId;
      }

      ConstraintLayout onboarding3 = (ConstraintLayout) rootView;

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      return new ActivityOnboarding3Binding((ConstraintLayout) rootView, imageView6, nextBtn,
          onboarding3, textView13, textView16);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
