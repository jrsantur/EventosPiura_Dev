/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.startup.piura.eventos.injector.components;


import android.content.Context;
import com.startup.piura.eventos.injector.Activity;
import com.startup.piura.eventos.injector.modulos.ActivityModule;
import dagger.Component;


@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Context context();
}
