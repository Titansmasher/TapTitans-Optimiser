package com.titansmasher.taptitansoptimizer.Model;

import com.titansmasher.taptitansoptimizer.Model.Enums.Effect;

/**
 * Created by Danny on 21/10/2016.
 */

public class Skill {
    public double value;
    public Effect effect;

    public Skill(double value, Effect effect) {
        this(effect, value);
    }

    public Skill(Effect effect, double value) {
        this.value = value;
        this.effect = effect;
    }
}
