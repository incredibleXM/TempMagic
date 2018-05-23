package com.example.asus1.helloworld;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.asus1.helloworld.action.FOO";
    private static final String ACTION_BAZ = "com.example.asus1.helloworld.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM = "com.example.asus1.helloworld.extra.PARAM";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM, param);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM, param);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param = intent.getStringExtra(EXTRA_PARAM);
                handleActionFoo(param);
            } else if (ACTION_BAZ.equals(action)) {
                final String param = intent.getStringExtra(EXTRA_PARAM);
                handleActionBaz(param);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param) {
        // TODO: Handle action Foo
        new Thread(new Runnable() {
            @Override
            public void run() {

                //left to be continued

            }
        }).start();
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
