package com.lonelycatgames.Xplore;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.lcg.PopupMenu;
import com.lonelycatgames.Xplore.App;
import com.lonelycatgames.Xplore.FileContentProvider;
import com.lonelycatgames.Xplore.FileSystem.l;
import com.lonelycatgames.Xplore.Music.MusicPlayerUi;
import com.lonelycatgames.Xplore.h;
import com.lonelycatgames.Xplore.m;
import com.lonelycatgames.Xplore.ops.NewsOperation;
import com.lonelycatgames.Xplore.ops.Operation;
import com.lonelycatgames.Xplore.ops.b1;
import com.lonelycatgames.Xplore.ops.c1;
import com.lonelycatgames.Xplore.ops.copy.CopyMoveService;
import com.lonelycatgames.Xplore.ops.d0;
import com.lonelycatgames.Xplore.ops.e0;
import com.lonelycatgames.Xplore.ops.g1;
import com.lonelycatgames.Xplore.ops.m0;
import com.lonelycatgames.Xplore.pane.Pane;
import com.lonelycatgames.Xplore.utils.HorizontalScroll;
import com.lonelycatgames.Xplore.utils.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.u1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.z0;

/* compiled from: Browser.kt */
public class Browser extends androidx.appcompat.app.c implements j0, com.lonelycatgames.Xplore.FileSystem.wifi.j, App.b {
    private static final float[] Z = {1.0f, 1.1f, 0.8f, 1.3f, 0.5f, 0.75f};
    /* access modifiers changed from: private */
    public static final g.o<Integer, String>[] a0 = {g.u.a(Integer.valueOf(C0557R.string.text), "text"), g.u.a(Integer.valueOf(C0557R.string.image), "image"), g.u.a(Integer.valueOf(C0557R.string.video), "video"), g.u.a(Integer.valueOf(C0557R.string.audio), "audio"), g.u.a(Integer.valueOf(C0557R.string.mime_all), "*")};
    public static final d b0 = new d((g) null);
    public i A;
    public ViewGroup B;
    public HorizontalScroll C;
    public View D;
    private boolean E;
    private ButtonsBar F;
    private Button G;
    private int H;
    private int I;
    private Dialog J;
    public g0 K;
    public com.lonelycatgames.Xplore.x.n L;
    private final g.g M = j.b(new w(this));
    private boolean N;
    /* access modifiers changed from: private */
    public u1 O;
    private boolean P;
    private com.lonelycatgames.Xplore.FileSystem.m Q;
    private g.g0.c.p<? super Boolean, ? super Intent, g.y> R;
    private g.g0.c.l<? super Intent, g.y> S;
    /* access modifiers changed from: private */
    public boolean T;
    private final Runnable U = new a(this);
    /* access modifiers changed from: private */
    public Operation V;
    /* access modifiers changed from: private */
    public int W;
    private final Runnable X = new b(this);
    private final /* synthetic */ j0 Y = k0.b();
    private final g.g w = j.b(new a0(this));
    public App x;
    private AudioManager y;
    public h z;

    /* compiled from: Browser.kt */
    protected final class ButtonsBar {
        private final ArrayList<Operation> a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f7180b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Browser f7181c;

        /* compiled from: Browser.kt */
        public static final class a extends androidx.recyclerview.widget.d {

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ ButtonsBar f7182e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(ButtonsBar buttonsBar, Context context, int i2) {
                super(context, i2);
                this.f7182e = buttonsBar;
            }

            public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
                g.g0.d.k.e(canvas, "c");
                g.g0.d.k.e(recyclerView, "parent");
                g.g0.d.k.e(a0Var, CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                this.f7182e.f7181c.w0().j().draw(canvas);
            }
        }

        /* compiled from: Browser.kt */
        public static final class b extends androidx.recyclerview.widget.d {

            /* renamed from: e  reason: collision with root package name */
            private final Rect f7183e = new Rect();

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Drawable f7184f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(ButtonsBar buttonsBar, Drawable drawable, Context context, int i2) {
                super(context, i2);
                this.f7184f = drawable;
            }

            public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
                g.g0.d.k.e(canvas, "c");
                g.g0.d.k.e(recyclerView, "parent");
                g.g0.d.k.e(a0Var, CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                int save = canvas.save();
                try {
                    int childCount = recyclerView.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = recyclerView.getChildAt(i2);
                        g.g0.d.k.b(childAt, "getChildAt(index)");
                        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager != null) {
                            layoutManager.T(childAt, this.f7183e);
                        }
                        int d2 = this.f7183e.right + c.d(childAt.getTranslationX());
                        if (d2 < recyclerView.getRight()) {
                            Drawable drawable = this.f7184f;
                            Rect rect = this.f7183e;
                            drawable.setBounds(d2 - (drawable.getIntrinsicWidth() / 2), rect.top, d2, rect.bottom);
                            this.f7184f.draw(canvas);
                        }
                    }
                } finally {
                    canvas.restoreToCount(save);
                }
            }
        }

        /* compiled from: Browser.kt */
        private final class c extends RecyclerView.g<a> implements View.OnClickListener, View.OnLongClickListener {

            /* renamed from: c  reason: collision with root package name */
            private long f7185c;

            /* compiled from: Browser.kt */
            private final class a extends RecyclerView.d0 {
                private final Button t;
                final /* synthetic */ c u;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(c cVar, View view) {
                    super(view);
                    g.g0.d.k.e(view, "root");
                    this.u = cVar;
                    Button button = (Button) view;
                    this.t = button;
                    button.setTextScaleX(0.9f);
                }

                public final void Q(Operation operation, List<? extends Object> list) {
                    boolean z;
                    g.g0.d.k.e(operation, "op");
                    g.g0.d.k.e(list, "payloads");
                    View view = this.a;
                    g.g0.d.k.d(view, "itemView");
                    view.setTag(operation);
                    Browser browser = ButtonsBar.this.f7181c;
                    List<com.lonelycatgames.Xplore.x.p> list2 = null;
                    if (list.isEmpty() || list.contains(c.TEXT_AND_ICON)) {
                        this.t.setText(operation.w(browser));
                        Integer valueOf = Integer.valueOf(operation.s(browser));
                        if (!(valueOf.intValue() != 0)) {
                            valueOf = null;
                        }
                        Drawable x = com.lcg.i0.h.x(browser, valueOf != null ? valueOf.intValue() : C0557R.drawable.op_settings);
                        if (x != null) {
                            this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, x.mutate(), (Drawable) null, (Drawable) null);
                        }
                    }
                    Pane j2 = ButtonsBar.this.f7181c.D0().j();
                    Pane q = ButtonsBar.this.f7181c.D0().q();
                    if (true ^ j2.e1().isEmpty()) {
                        list2 = j2.e1();
                    }
                    if (list2 == null) {
                        z = operation.x(browser, j2, q, j2.L0());
                    } else {
                        z = operation.y(browser, j2, q, list2);
                    }
                    if (this.t.isEnabled() != z) {
                        this.t.setEnabled(z);
                        if (!z) {
                            this.t.setPressed(false);
                        }
                        this.t.setAlpha(z ? 1.0f : 0.5f);
                    }
                }
            }

            public c() {
            }

            /* renamed from: C */
            public void r(a aVar, int i2) {
                g.g0.d.k.e(aVar, "vh");
                Operation operation = ButtonsBar.this.b().get(i2);
                g.g0.d.k.d(operation, "items[i]");
                aVar.Q(operation, p.e());
            }

            /* renamed from: D */
            public void s(a aVar, int i2, List<? extends Object> list) {
                g.g0.d.k.e(aVar, "vh");
                g.g0.d.k.e(list, "payloads");
                Operation operation = ButtonsBar.this.b().get(i2);
                g.g0.d.k.d(operation, "items[i]");
                aVar.Q(operation, list);
            }

            /* renamed from: E */
            public a t(ViewGroup viewGroup, int i2) {
                g.g0.d.k.e(viewGroup, "parent");
                View inflate = ButtonsBar.this.f7181c.getLayoutInflater().inflate(C0557R.layout.button, viewGroup, false);
                inflate.setOnClickListener(this);
                inflate.setOnLongClickListener(this);
                g.g0.d.k.d(inflate, "v");
                return new a(this, inflate);
            }

            public int c() {
                return ButtonsBar.this.b().size();
            }

            public void onClick(View view) {
                g.g0.d.k.e(view, "v");
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f7185c < ((long) 400)) {
                    App.f0.k("Ignoring double-click on button");
                } else {
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type com.lonelycatgames.Xplore.ops.Operation");
                    Operation operation = (Operation) tag;
                    ButtonsBar.this.f7181c.s0().c0().f(operation, false);
                    Browser browser = ButtonsBar.this.f7181c;
                    operation.i(browser, browser.D0().j(), ButtonsBar.this.f7181c.D0().q(), false);
                }
                this.f7185c = currentTimeMillis;
            }

            public boolean onLongClick(View view) {
                g.g0.d.k.e(view, "v");
                Object tag = view.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.lonelycatgames.Xplore.ops.Operation");
                Operation operation = (Operation) tag;
                ButtonsBar.this.f7181c.s0().c0().f(operation, true);
                Browser browser = ButtonsBar.this.f7181c;
                operation.i(browser, browser.D0().j(), ButtonsBar.this.f7181c.D0().q(), true);
                return true;
            }
        }

        public ButtonsBar(Browser browser, RecyclerView recyclerView) {
            g.g0.d.k.e(recyclerView, "list");
            this.f7181c = browser;
            this.f7180b = recyclerView;
            int integer = browser.getResources().getInteger(C0557R.integer.button_columns);
            recyclerView.setAdapter(new c());
            recyclerView.setLayoutManager(new GridLayoutManager(this, integer, browser, integer) {
                public boolean w0() {
                    return true;
                }
            });
            Context context = recyclerView.getContext();
            g.g0.d.k.d(context, "list.context");
            Drawable x = com.lcg.i0.h.x(context, C0557R.drawable.list_divider);
            g.g0.d.k.c(x);
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = browser.getResources().getDimensionPixelSize(C0557R.dimen.button_width) * integer;
            recyclerView.setLayoutParams(layoutParams);
            a aVar = new a(this, recyclerView.getContext(), 1);
            aVar.l(x);
            g.y yVar = g.y.a;
            recyclerView.k(aVar);
            androidx.recyclerview.widget.c cVar = new androidx.recyclerview.widget.c();
            cVar.R(false);
            recyclerView.setItemAnimator(cVar);
            if (integer > 1) {
                Context context2 = recyclerView.getContext();
                g.g0.d.k.d(context2, "list.context");
                Drawable x2 = com.lcg.i0.h.x(context2, C0557R.drawable.list_divider_v);
                g.g0.d.k.c(x2);
                recyclerView.k(new b(this, x2, recyclerView.getContext(), 0));
            }
            d();
        }

        private final void a(Operation operation) {
            if (this.f7181c.l0(operation)) {
                this.a.add(operation);
            }
        }

        public final ArrayList<Operation> b() {
            return this.a;
        }

        public final RecyclerView c() {
            return this.f7180b;
        }

        public final void d() {
            this.a.clear();
            if (!this.f7181c.C0() && com.lonelycatgames.Xplore.utils.c.l.w()) {
                a(com.lonelycatgames.Xplore.ops.m.m);
            }
            NewsOperation newsOperation = NewsOperation.n;
            if (newsOperation.P()) {
                a(newsOperation);
            }
            ArrayList<Operation> arrayList = this.a;
            Operation[] b2 = this.f7181c.s0().c0().b();
            ArrayList arrayList2 = new ArrayList();
            for (Operation operation : b2) {
                if (operation.p() && this.f7181c.l0(operation)) {
                    arrayList2.add(operation);
                }
            }
            arrayList.addAll(arrayList2);
            if (this.a.isEmpty()) {
                a(com.lonelycatgames.Xplore.ops.g.f9631j);
            }
            RecyclerView.g adapter = this.f7180b.getAdapter();
            if (adapter != null) {
                adapter.h();
            }
        }

        public final void e(boolean z) {
            RecyclerView.g adapter;
            if (!this.f7180b.isInLayout() && (adapter = this.f7180b.getAdapter()) != null) {
                adapter.m(0, this.a.size(), c.ENABLED);
                if (z) {
                    adapter.m(0, this.a.size(), c.TEXT_AND_ICON);
                }
            }
        }
    }

    /* compiled from: Runnable.kt */
    public static final class a implements Runnable {
        final /* synthetic */ Browser a;

        public a(Browser browser) {
            this.a = browser;
        }

        public final void run() {
            for (Pane pane : this.a.D0().w()) {
                com.lonelycatgames.Xplore.x.h P0 = pane.P0();
                int i2 = 0;
                while (i2 < P0.size()) {
                    int i3 = i2 + 1;
                    Object obj = P0.get(i2);
                    g.g0.d.k.d(obj, "l[i++]");
                    com.lonelycatgames.Xplore.x.m mVar = (com.lonelycatgames.Xplore.x.m) obj;
                    if (mVar.l0() == 0 && (mVar instanceof com.lonelycatgames.Xplore.x.g) && (mVar.g0() instanceof com.lonelycatgames.Xplore.FileSystem.j)) {
                        Pane.W1(pane, (com.lonelycatgames.Xplore.x.g) mVar, true, (String) null, false, 12, (Object) null);
                    }
                    i2 = i3;
                }
            }
        }
    }

    /* compiled from: Browser.kt */
    static final class a0 extends g.g0.d.l implements g.g0.c.a<com.lonelycatgames.Xplore.o0.a> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Browser f7187b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a0(Browser browser) {
            super(0);
            this.f7187b = browser;
        }

        /* renamed from: a */
        public final com.lonelycatgames.Xplore.o0.a d() {
            String k = l.k(this.f7187b.s0().F(), "tmdb_default_language", (String) null, 2, (Object) null);
            if (k == null) {
                Locale locale = Locale.getDefault();
                g.g0.d.k.d(locale, "Locale.getDefault()");
                k = locale.getLanguage();
            }
            g.g0.d.k.d(k, "app.database.getPref(Con…ale.getDefault().language");
            return new com.lonelycatgames.Xplore.o0.a(k);
        }
    }

    /* compiled from: Runnable.kt */
    public static final class b implements Runnable {
        final /* synthetic */ Browser a;

        public b(Browser browser) {
            this.a = browser;
        }

        public final void run() {
            Operation W;
            if (this.a.W == 4 && (W = this.a.V) != null) {
                this.a.N0(W, 4, true);
            }
        }
    }

    @g.d0.k.a.f(c = "com.lonelycatgames.Xplore.Browser$trashClean$1", f = "Browser.kt", l = {1767}, m = "invokeSuspend")
    /* compiled from: Browser.kt */
    static final class b0 extends g.d0.k.a.l implements g.g0.c.p<j0, g.d0.d<? super g.y>, Object> {

        /* renamed from: e  reason: collision with root package name */
        private /* synthetic */ Object f7188e;

        /* renamed from: f  reason: collision with root package name */
        int f7189f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Browser f7190g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f7191h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ int f7192i;

        @g.d0.k.a.f(c = "com.lonelycatgames.Xplore.Browser$trashClean$1$1$1", f = "Browser.kt", l = {}, m = "invokeSuspend")
        /* compiled from: Browser.kt */
        static final class a extends g.d0.k.a.l implements g.g0.c.p<j0, g.d0.d<? super g.y>, Object> {

            /* renamed from: e  reason: collision with root package name */
            int f7193e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ String f7194f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ b0 f7195g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ j0 f7196h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ long f7197i;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, g.d0.d dVar, b0 b0Var, j0 j0Var, long j2) {
                super(2, dVar);
                this.f7194f = str;
                this.f7195g = b0Var;
                this.f7196h = j0Var;
                this.f7197i = j2;
            }

            public final g.d0.d<g.y> a(Object obj, g.d0.d<?> dVar) {
                g.g0.d.k.e(dVar, "completion");
                return new a(this.f7194f, dVar, this.f7195g, this.f7196h, this.f7197i);
            }

            public final Object l(Object obj, Object obj2) {
                return ((a) a(obj, (g.d0.d) obj2)).u(g.y.a);
            }

            public final Object u(Object obj) {
                Object unused = d.c();
                if (this.f7193e == 0) {
                    g.q.b(obj);
                    for (Pane X1 : this.f7195g.f7190g.D0().w()) {
                        X1.X1(this.f7194f);
                    }
                    return g.y.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b0(Browser browser, int i2, int i3, g.d0.d dVar) {
            super(2, dVar);
            this.f7190g = browser;
            this.f7191h = i2;
            this.f7192i = i3;
        }

        public final g.d0.d<g.y> a(Object obj, g.d0.d<?> dVar) {
            g.g0.d.k.e(dVar, "completion");
            b0 b0Var = new b0(this.f7190g, this.f7191h, this.f7192i, dVar);
            b0Var.f7188e = obj;
            return b0Var;
        }

        public final Object l(Object obj, Object obj2) {
            return ((b0) a(obj, (g.d0.d) obj2)).u(g.y.a);
        }

        public final Object u(Object obj) {
            j0 j0Var;
            long j2;
            Object c2 = d.c();
            int i2 = this.f7189f;
            if (i2 == 0) {
                g.q.b(obj);
                j0 j0Var2 = (j0) this.f7188e;
                this.f7188e = j0Var2;
                this.f7189f = 1;
                if (v0.a(((long) this.f7191h) * 1000, this) == c2) {
                    return c2;
                }
                j0Var = j0Var2;
            } else if (i2 == 1) {
                g.q.b(obj);
                j0Var = (j0) this.f7188e;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long currentTimeMillis = this.f7190g.s0().z().C() != 0 ? System.currentTimeMillis() - ((long) 1209600000) : Long.MAX_VALUE;
            for (com.lonelycatgames.Xplore.p0.a k : new ArrayList(com.lonelycatgames.Xplore.FileSystem.l.p.g())) {
                String k2 = k.k();
                if (k2 != null) {
                    try {
                        com.lonelycatgames.Xplore.x.g gVar = new com.lonelycatgames.Xplore.x.g(l.a.f(com.lonelycatgames.Xplore.FileSystem.l.p, k2, false, 2, (Object) null), 0, 2, (g) null);
                        gVar.V0(k2);
                        int U = this.f7190g.m0(gVar, currentTimeMillis);
                        if (U > 0) {
                            App.a aVar = App.f0;
                            aVar.k("Cleaned trash " + k2 + ", deleted files: " + U);
                            if (this.f7190g.s0().z().C() != 0) {
                                g2 c3 = z0.c();
                                a aVar2 = new a(k2, (g.d0.d) null, this, j0Var, currentTimeMillis);
                                j2 = currentTimeMillis;
                                try {
                                    u1 unused = h.d(j0Var, c3, (m0) null, aVar2, 2, (Object) null);
                                } catch (StackOverflowError e2) {
                                    e = e2;
                                }
                                currentTimeMillis = j2;
                            }
                        }
                        j2 = currentTimeMillis;
                    } catch (StackOverflowError e3) {
                        e = e3;
                        j2 = currentTimeMillis;
                        e.printStackTrace();
                        currentTimeMillis = j2;
                    }
                    currentTimeMillis = j2;
                }
            }
            this.f7190g.s0().F().O("last_trash_clean_day", this.f7192i);
            return g.y.a;
        }
    }

    /* compiled from: Browser.kt */
    private enum c {
        TEXT_AND_ICON,
        ENABLED
    }

    /* compiled from: Browser.kt */
    public static final class d {
        private d() {
        }

        public final void a(Context context, int i2, int i3, String str) {
            g.g0.d.k.e(context, "ctx");
            g.g0.d.k.e(str, "reason");
            Intent intent = new Intent(context, Browser.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setAction("askDonation");
            intent.putExtra("amount", i2);
            intent.putExtra("reason", str);
            if (i3 != 0) {
                intent.putExtra("icon", i3);
            }
            context.startActivity(intent);
        }

        public final g.o<Integer, String>[] b() {
            return Browser.a0;
        }

        public /* synthetic */ d(g gVar) {
            this();
        }
    }

    /* compiled from: Browser.kt */
    private final class e extends c1 {
        private final File m;
        private final Uri n;
        private final String o;
        final /* synthetic */ Browser p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Browser browser, h hVar, Uri uri, String str, long j2) {
            super(hVar, j2, false, 4, (g) null);
            File file;
            g.g0.d.k.e(hVar, "_st");
            g.g0.d.k.e(uri, "srcUri");
            g.g0.d.k.e(str, "fileName");
            this.p = browser;
            this.n = uri;
            this.o = str;
            boolean z = true;
            File i0 = App.i0(browser.s0(), false, 1, (Object) null);
            if (A().length() <= 0 ? false : z) {
                file = new File(i0, com.lonelycatgames.Xplore.utils.g.f10357c.a(A()));
            } else {
                file = File.createTempFile("content", '.' + com.lcg.i0.h.y(A()), i0);
                g.g0.d.k.d(file, "File.createTempFile(\"con…tension(fileName)}\", dir)");
            }
            this.m = file;
            g(browser);
            browser.n0(false);
            t().f();
        }

        /* access modifiers changed from: protected */
        public String A() {
            return this.o;
        }

        /* access modifiers changed from: protected */
        public void u(androidx.appcompat.app.b bVar) {
            g.g0.d.k.e(bVar, "dlg");
            bVar.m(this.p.getString(C0557R.string.copying_file_to_temp, new Object[]{A()}));
        }

        /* access modifiers changed from: protected */
        public void v() {
            Pane pane = j().w()[0];
            String absolutePath = this.m.getAbsolutePath();
            g.g0.d.k.d(absolutePath, "tmpFile.absolutePath");
            Pane.H1(pane, absolutePath, A(), (String) null, 4, (Object) null);
        }

        /* access modifiers changed from: protected */
        public InputStream x() {
            try {
                InputStream openInputStream = this.p.getContentResolver().openInputStream(this.n);
                if (openInputStream != null) {
                    return openInputStream;
                }
                throw new FileNotFoundException();
            } catch (IOException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new IOException(com.lcg.i0.h.H(e3));
            }
        }

        /* access modifiers changed from: protected */
        public OutputStream y() {
            return new FileOutputStream(this.m);
        }
    }

    /* compiled from: Browser.kt */
    protected static final class f {
        private final h a;

        public f(h hVar) {
            g.g0.d.k.e(hVar, CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            this.a = hVar;
        }

        public final h a() {
            return this.a;
        }
    }

    /* compiled from: Browser.kt */
    private static final class g {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final Object[] f7200b;

        public g(int i2, Object... objArr) {
            g.g0.d.k.e(objArr, "items");
            this.a = i2;
            this.f7200b = objArr;
        }

        public final Object[] a() {
            return this.f7200b;
        }

        public final int b() {
            return this.a;
        }
    }

    /* compiled from: Browser.kt */
    private static final class h {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7201b;

        /* renamed from: c  reason: collision with root package name */
        private final g.g0.c.l<h, g.y> f7202c;

        public h(int i2, int i3, g.g0.c.l<? super h, g.y> lVar) {
            g.g0.d.k.e(lVar, "run");
            this.a = i2;
            this.f7201b = i3;
            this.f7202c = lVar;
        }

        public final int a() {
            return this.a;
        }

        public final g.g0.c.l<h, g.y> b() {
            return this.f7202c;
        }

        public final int c() {
            return this.f7201b;
        }
    }

    /* compiled from: Browser.kt */
    static final class i implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ Object a;

        i(Object obj) {
            this.a = obj;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            ((h) this.a).b().o(this.a);
            return true;
        }
    }

    /* compiled from: Browser.kt */
    static final class j implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ Browser a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f7203b;

        j(Browser browser, Object obj) {
            this.a = browser;
            this.f7203b = obj;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            Browser browser = this.a;
            browser.s0().c0().f((Operation) this.f7203b, false);
            Toolbar toolbar = (Toolbar) this.a.findViewById(C0557R.id.toolbar);
            g.g0.d.k.d(menuItem, "item");
            View findViewById = toolbar.findViewById(menuItem.getItemId());
            g.g0.d.k.d(toolbar, "toolbar");
            ((Operation) this.f7203b).j(browser, toolbar, findViewById);
            return true;
        }
    }

    /* compiled from: Browser.kt */
    public static final class k extends com.lcg.h {

        /* renamed from: f  reason: collision with root package name */
        private boolean f7204f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Browser f7205g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f7206h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f7207i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Browser browser, boolean z, String str, App app, String str2) {
            super(app, str2);
            this.f7205g = browser;
            this.f7206h = z;
            this.f7207i = str;
        }

        /* access modifiers changed from: protected */
        public void i() {
            if (this.f7204f) {
                this.f7205g.s0().R0();
                com.lcg.i0.h.l0(this.f7205g.G0());
                return;
            }
            this.f7205g.finish();
        }

        /* access modifiers changed from: protected */
        public void j(CharSequence charSequence) {
            g.g0.d.k.e(charSequence, "err");
            this.f7205g.X0(charSequence);
        }

        /* access modifiers changed from: protected */
        public void l(String str, boolean z) {
            if ((!this.f7206h || str != null) && (str == null || !g.g0.d.k.a(str, this.f7207i))) {
                Browser browser = this.f7205g;
                String string = browser.getString(C0557R.string.TXT_INVALID_PASSWORD);
                g.g0.d.k.d(string, "getString(R.string.TXT_INVALID_PASSWORD)");
                browser.X0(string);
                return;
            }
            this.f7204f = true;
        }
    }

    @g.d0.k.a.f(c = "com.lonelycatgames.Xplore.Browser$demoShowOtherPane$1", f = "Browser.kt", l = {1666, 1668, 1671}, m = "invokeSuspend")
    /* compiled from: Browser.kt */
    static final class l extends g.d0.k.a.l implements g.g0.c.p<j0, g.d0.d<? super g.y>, Object> {

        /* renamed from: e  reason: collision with root package name */
        long f7208e;

        /* renamed from: f  reason: collision with root package name */
        int f7209f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Browser f7210g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(Browser browser, g.d0.d dVar) {
            super(2, dVar);
            this.f7210g = browser;
        }

        public final g.d0.d<g.y> a(Object obj, g.d0.d<?> dVar) {
            g.g0.d.k.e(dVar, "completion");
            return new l(this.f7210g, dVar);
        }

        public final Object l(Object obj, Object obj2) {
            return ((l) a(obj, (g.d0.d) obj2)).u(g.y.a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object u(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = g.d0.j.d.c()
                int r1 = r7.f7209f
                r2 = 3
                r3 = 1
                r4 = 2
                if (r1 == 0) goto L_0x0029
                if (r1 == r3) goto L_0x0023
                if (r1 == r4) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                g.q.b(r8)
                goto L_0x007c
            L_0x0015:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001d:
                long r3 = r7.f7208e
                g.q.b(r8)
                goto L_0x0057
            L_0x0023:
                long r5 = r7.f7208e
                g.q.b(r8)
                goto L_0x0046
            L_0x0029:
                g.q.b(r8)
                r5 = 1600(0x640, double:7.905E-321)
                com.lonelycatgames.Xplore.Browser r8 = r7.f7210g
                int r8 = r8.y0()
                if (r8 != r4) goto L_0x0058
                com.lonelycatgames.Xplore.Browser r8 = r7.f7210g
                r8.f1()
                r7.f7208e = r5
                r7.f7209f = r3
                java.lang.Object r8 = kotlinx.coroutines.v0.a(r5, r7)
                if (r8 != r0) goto L_0x0046
                return r0
            L_0x0046:
                com.lonelycatgames.Xplore.Browser r8 = r7.f7210g
                r8.f1()
                r7.f7208e = r5
                r7.f7209f = r4
                java.lang.Object r8 = kotlinx.coroutines.v0.a(r5, r7)
                if (r8 != r0) goto L_0x0056
                return r0
            L_0x0056:
                r3 = r5
            L_0x0057:
                r5 = r3
            L_0x0058:
                com.lonelycatgames.Xplore.Browser r8 = r7.f7210g
                com.lonelycatgames.Xplore.Browser$ButtonsBar r8 = com.lonelycatgames.Xplore.Browser.V(r8)
                androidx.recyclerview.widget.RecyclerView r8 = r8.c()
                com.lonelycatgames.Xplore.Browser r1 = r7.f7210g
                com.lonelycatgames.Xplore.Browser$ButtonsBar r1 = com.lonelycatgames.Xplore.Browser.V(r1)
                java.util.ArrayList r1 = r1.b()
                int r1 = g.a0.p.g(r1)
                r8.x1(r1)
                r7.f7209f = r2
                java.lang.Object r8 = kotlinx.coroutines.v0.a(r5, r7)
                if (r8 != r0) goto L_0x007c
                return r0
            L_0x007c:
                com.lonelycatgames.Xplore.Browser r8 = r7.f7210g
                com.lonelycatgames.Xplore.Browser$ButtonsBar r8 = com.lonelycatgames.Xplore.Browser.V(r8)
                androidx.recyclerview.widget.RecyclerView r8 = r8.c()
                r0 = 0
                r8.x1(r0)
                g.y r8 = g.y.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.l.u(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Browser.kt */
    static final class m extends g.g0.d.l implements g.g0.c.p<Pane, com.lonelycatgames.Xplore.x.m, g.y> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g.g0.d.b0 f7211b;

        /* compiled from: Browser.kt */
        static final class a extends g.g0.d.l implements g.g0.c.a<g.y> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Pane f7212b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Pane pane) {
                super(0);
                this.f7212b = pane;
            }

            public final void a() {
                this.f7212b.u0();
            }

            public /* bridge */ /* synthetic */ Object d() {
                a();
                return g.y.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(g.g0.d.b0 b0Var, Intent intent) {
            super(2);
            this.f7211b = b0Var;
        }

        public final void a(Pane pane, com.lonelycatgames.Xplore.x.m mVar) {
            g.g0.d.k.e(pane, "$receiver");
            g.g0.d.k.e(mVar, "le");
            com.lcg.i0.h.Z(0, new a(pane), 1, (Object) null);
            if (g.g0.d.k.a(mVar.X(), (String) this.f7211b.a) && (mVar instanceof com.lonelycatgames.Xplore.x.p)) {
                ((com.lonelycatgames.Xplore.x.p) mVar).x(true);
            }
        }

        public /* bridge */ /* synthetic */ Object l(Object obj, Object obj2) {
            a((Pane) obj, (com.lonelycatgames.Xplore.x.m) obj2);
            return g.y.a;
        }
    }

    /* compiled from: Browser.kt */
    public static final class n implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Browser a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f7213b;

        n(Browser browser, h hVar) {
            this.a = browser;
            this.f7213b = hVar;
        }

        public void onGlobalLayout() {
            this.a.u0().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.a.u0().scrollTo(this.f7213b.k() > 0 ? 5000 : 0, 0);
        }
    }

    @g.d0.k.a.f(c = "com.lonelycatgames.Xplore.Browser$maybeAskForReview$1", f = "Browser.kt", l = {1919, 1920, 1921}, m = "invokeSuspend")
    /* compiled from: Browser.kt */
    static final class o extends g.d0.k.a.l implements g.g0.c.p<j0, g.d0.d<? super g.y>, Object> {

        /* renamed from: e  reason: collision with root package name */
        int f7214e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Browser f7215f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(Browser browser, g.d0.d dVar) {
            super(2, dVar);
            this.f7215f = browser;
        }

        public final g.d0.d<g.y> a(Object obj, g.d0.d<?> dVar) {
            g.g0.d.k.e(dVar, "completion");
            return new o(this.f7215f, dVar);
        }

        public final Object l(Object obj, Object obj2) {
            return ((o) a(obj, (g.d0.d) obj2)).u(g.y.a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0054 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object u(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = g.d0.j.d.c()
                int r1 = r7.f7214e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0025
                if (r1 == r4) goto L_0x0021
                if (r1 == r3) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                g.q.b(r8)
                goto L_0x0055
            L_0x0015:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001d:
                g.q.b(r8)
                goto L_0x0042
            L_0x0021:
                g.q.b(r8)
                goto L_0x0033
            L_0x0025:
                g.q.b(r8)
                r5 = 3000(0xbb8, double:1.482E-320)
                r7.f7214e = r4
                java.lang.Object r8 = kotlinx.coroutines.v0.a(r5, r7)
                if (r8 != r0) goto L_0x0033
                return r0
            L_0x0033:
                com.lonelycatgames.Xplore.Browser r8 = r7.f7215f
                com.google.android.play.core.review.a r8 = r8.B0()
                r7.f7214e = r3
                java.lang.Object r8 = d.a.a.d.a.b.a.b(r8, r7)
                if (r8 != r0) goto L_0x0042
                return r0
            L_0x0042:
                com.google.android.play.core.review.ReviewInfo r8 = (com.google.android.play.core.review.ReviewInfo) r8
                com.lonelycatgames.Xplore.Browser r1 = r7.f7215f
                com.google.android.play.core.review.a r1 = r1.B0()
                com.lonelycatgames.Xplore.Browser r3 = r7.f7215f
                r7.f7214e = r2
                java.lang.Object r8 = d.a.a.d.a.b.a.a(r1, r3, r8, r7)
                if (r8 != r0) goto L_0x0055
                return r0
            L_0x0055:
                g.y r8 = g.y.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.o.u(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Browser.kt */
    static final class p extends g.g0.d.l implements g.g0.c.l<h, g.y> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Browser f7216b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(Browser browser) {
            super(1);
            this.f7216b = browser;
        }

        public final void a(h hVar) {
            g.g0.d.k.e(hVar, "$receiver");
            Browser browser = this.f7216b;
            String string = browser.getString(hVar.c());
            g.g0.d.k.d(string, "getString(title)");
            new com.lonelycatgames.Xplore.utils.h(browser, string, hVar.a(), "");
        }

        public /* bridge */ /* synthetic */ Object o(Object obj) {
            a((h) obj);
            return g.y.a;
        }
    }

    /* compiled from: Browser.kt */
    static final class q extends g.g0.d.l implements g.g0.c.l<h, g.y> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Browser f7217b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(Browser browser) {
            super(1);
            this.f7217b = browser;
        }

        public final void a(h hVar) {
            g.g0.d.k.e(hVar, "$receiver");
            this.f7217b.startActivityForResult(new Intent(this.f7217b, Tweaks.class), 1);
        }

        public /* bridge */ /* synthetic */ Object o(Object obj) {
            a((h) obj);
            return g.y.a;
        }
    }

    /* compiled from: Browser.kt */
    static final class r extends g.g0.d.l implements g.g0.c.l<String, CharSequence> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f7218b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(Bundle bundle) {
            super(1);
            this.f7218b = bundle;
        }

        /* renamed from: a */
        public final CharSequence o(String str) {
            Object obj = this.f7218b.get(str);
            if (obj == null) {
                obj = null;
            } else if (obj instanceof Object[]) {
                g.g0.d.k.d(obj, "v");
                obj = l.a0((Object[]) obj, ", ", "array[", "]", 0, (CharSequence) null, (g.g0.c.l) null, 56, (Object) null);
            } else if (obj instanceof int[]) {
                g.g0.d.k.d(obj, "v");
                obj = l.Y((int[]) obj, ", ", "int[", "]", 0, (CharSequence) null, (g.g0.c.l) null, 56, (Object) null);
            } else if (obj instanceof long[]) {
                g.g0.d.k.d(obj, "v");
                obj = l.Z((long[]) obj, ", ", "long[", "]", 0, (CharSequence) null, (g.g0.c.l) null, 56, (Object) null);
            } else if (obj instanceof double[]) {
                g.g0.d.k.d(obj, "v");
                obj = l.X((double[]) obj, ", ", "double[", "]", 0, (CharSequence) null, (g.g0.c.l) null, 56, (Object) null);
            } else if (obj instanceof boolean[]) {
                g.g0.d.k.d(obj, "v");
                obj = l.b0((boolean[]) obj, ", ", "bool[", "]", 0, (CharSequence) null, (g.g0.c.l) null, 56, (Object) null);
            } else if (obj instanceof Iterable) {
                g.g0.d.k.d(obj, "v");
                obj = x.I((Iterable) obj, ", ", "[", "]", 0, (CharSequence) null, (g.g0.c.l) null, 56, (Object) null);
            }
            return str + " = " + obj;
        }
    }

    @g.d0.k.a.f(c = "com.lonelycatgames.Xplore.Browser$onBackPressed$2$1", f = "Browser.kt", l = {606}, m = "invokeSuspend")
    /* compiled from: Browser.kt */
    static final class s extends g.d0.k.a.l implements g.g0.c.p<j0, g.d0.d<? super g.y>, Object> {

        /* renamed from: e  reason: collision with root package name */
        int f7219e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Browser f7220f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(g.d0.d dVar, Browser browser) {
            super(2, dVar);
            this.f7220f = browser;
        }

        public final g.d0.d<g.y> a(Object obj, g.d0.d<?> dVar) {
            g.g0.d.k.e(dVar, "completion");
            return new s(dVar, this.f7220f);
        }

        public final Object l(Object obj, Object obj2) {
            return ((s) a(obj, (g.d0.d) obj2)).u(g.y.a);
        }

        public final Object u(Object obj) {
            Object c2 = d.c();
            int i2 = this.f7219e;
            if (i2 == 0) {
                g.q.b(obj);
                App.i1(this.f7220f.s0(), C0557R.string.double_back_to_exit, false, 2, (Object) null);
                this.f7219e = 1;
                if (v0.a((long) 2000, this) == c2) {
                    return c2;
                }
            } else if (i2 == 1) {
                g.q.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f7220f.O = null;
            return g.y.a;
        }
    }

    /* compiled from: Browser.kt */
    static final class t implements View.OnClickListener {
        final /* synthetic */ Browser a;

        t(Browser browser) {
            this.a = browser;
        }

        public final void onClick(View view) {
            Intent putExtra = new Intent(this.a, MusicPlayerUi.class).putExtra("connect_to_player", true);
            g.g0.d.k.d(putExtra, "Intent(this@Browser, Mus….CONNECT_TO_PLAYER, true)");
            this.a.startActivity(putExtra);
        }
    }

    /* compiled from: Utils.kt */
    public static final class u implements View.OnClickListener {
        final /* synthetic */ Browser a;

        public u(Browser browser) {
            this.a = browser;
        }

        public final void onClick(View view) {
            this.a.f1();
        }
    }

    /* compiled from: Browser.kt */
    static final class v implements View.OnClickListener {
        final /* synthetic */ Browser a;

        v(Browser browser) {
            this.a = browser;
        }

        public final void onClick(View view) {
            Browser browser = this.a;
            g.g0.d.k.d(view, "v");
            Object[] Y = this.a.x0();
            browser.b1(view, Arrays.copyOf(Y, Y.length));
        }
    }

    /* compiled from: Browser.kt */
    static final class w extends g.g0.d.l implements g.g0.c.a<com.google.android.play.core.review.a> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Browser f7221b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(Browser browser) {
            super(0);
            this.f7221b = browser;
        }

        /* renamed from: a */
        public final com.google.android.play.core.review.a d() {
            com.google.android.play.core.review.a a = com.google.android.play.core.review.b.a(this.f7221b);
            g.g0.d.k.d(a, "ReviewManagerFactory.create(this)");
            return a;
        }
    }

    /* compiled from: Browser.kt */
    static final class x extends g.g0.d.l implements g.g0.c.l<Intent, g.y> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Browser f7222b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(Browser browser) {
            super(1);
            this.f7222b = browser;
        }

        public final void a(Intent intent) {
            g.g0.d.k.e(intent, "in1");
            Uri data = intent.getData();
            if (data != null) {
                this.f7222b.r0(intent);
                this.f7222b.S0(intent, data.getPath());
            }
        }

        public /* bridge */ /* synthetic */ Object o(Object obj) {
            a((Intent) obj);
            return g.y.a;
        }
    }

    /* compiled from: Browser.kt */
    static final class y implements DialogInterface.OnDismissListener {
        final /* synthetic */ Browser a;

        y(Browser browser) {
            this.a = browser;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.T = false;
        }
    }

    /* compiled from: Browser.kt */
    static final class z extends g.g0.d.l implements g.g0.c.q<PopupMenu, PopupMenu.b, Boolean, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Browser f7223b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f7224c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(Browser browser, View view) {
            super(3);
            this.f7223b = browser;
            this.f7224c = view;
        }

        public final boolean a(PopupMenu popupMenu, PopupMenu.b bVar, boolean z) {
            g.g0.d.k.e(popupMenu, "$receiver");
            g.g0.d.k.e(bVar, "item");
            Object f2 = bVar.f();
            if (f2 instanceof Operation) {
                Pane j2 = this.f7223b.D0().j();
                ((Operation) f2).D(this.f7223b, j2, (Pane) null, j2.L0(), z);
                return true;
            } else if (f2 instanceof g) {
                Browser browser = this.f7223b;
                View view = this.f7224c;
                Object[] a = ((g) f2).a();
                browser.b1(view, Arrays.copyOf(a, a.length));
                return true;
            } else if (!(f2 instanceof h)) {
                return true;
            } else {
                ((h) f2).b().o(f2);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2, Object obj3) {
            return Boolean.valueOf(a((PopupMenu) obj, (PopupMenu.b) obj2, ((Boolean) obj3).booleanValue()));
        }
    }

    /* access modifiers changed from: private */
    public final com.google.android.play.core.review.a B0() {
        return (com.google.android.play.core.review.a) this.M.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void I0(android.content.Intent r28, com.lonelycatgames.Xplore.Browser.f r29) {
        /*
            r27 = this;
            r8 = r27
            r9 = r28
            g.g0.d.b0 r10 = new g.g0.d.b0
            r10.<init>()
            r11 = 0
            r10.a = r11
            com.lonelycatgames.Xplore.h r12 = r8.z
            if (r12 == 0) goto L_0x02e4
            java.lang.String r13 = ""
            r14 = -1
            r15 = 0
            r6 = 1
            if (r9 == 0) goto L_0x014a
            java.lang.String r0 = r28.getAction()
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r1 = g.g0.d.k.a(r0, r1)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "org.openintents.action.VIEW_DIRECTORY"
            boolean r1 = g.g0.d.k.a(r0, r1)
            if (r1 == 0) goto L_0x002c
            goto L_0x0058
        L_0x002c:
            java.lang.String r1 = "askDonation"
            boolean r0 = g.g0.d.k.a(r1, r0)
            if (r0 == 0) goto L_0x014a
            boolean r0 = r8.T
            if (r0 != 0) goto L_0x014a
            java.lang.String r0 = "amount"
            int r0 = r9.getIntExtra(r0, r6)
            java.lang.String r1 = "icon"
            int r1 = r9.getIntExtra(r1, r15)
            java.lang.String r2 = "reason"
            java.lang.String r2 = r9.getStringExtra(r2)
            if (r2 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r2 = r13
        L_0x004e:
            java.lang.String r3 = "int.getStringExtra(INTEN…RA_DONATION_REASON) ?: \"\""
            g.g0.d.k.d(r2, r3)
            r8.W0(r0, r1, r2)
            goto L_0x014a
        L_0x0058:
            android.net.Uri r4 = r28.getData()
            if (r4 == 0) goto L_0x014c
            r8.P = r6
            boolean r0 = com.lcg.i0.h.N(r4)
            if (r0 == 0) goto L_0x00ef
            java.lang.String r0 = r4.getPath()
            if (r0 == 0) goto L_0x00ef
            java.lang.String r0 = com.lcg.i0.h.J(r4)
            java.lang.String r1 = "openStandalone"
            boolean r1 = r9.getBooleanExtra(r1, r15)
            if (r1 != 0) goto L_0x00d4
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r2 = r2.isDirectory()
            if (r2 != 0) goto L_0x00d4
            com.lonelycatgames.Xplore.FileSystem.c$a r2 = com.lonelycatgames.Xplore.FileSystem.c.k
            java.lang.String r3 = r28.getType()
            boolean r2 = r2.b(r3)
            if (r2 == 0) goto L_0x0091
        L_0x008f:
            r1 = 1
            goto L_0x00d4
        L_0x0091:
            java.lang.String r2 = com.lcg.i0.h.y(r0)
            if (r2 != 0) goto L_0x0098
            goto L_0x00d4
        L_0x0098:
            int r3 = r2.hashCode()
            r4 = 1827(0x723, float:2.56E-42)
            if (r3 == r4) goto L_0x00cb
            r4 = 104987(0x19a1b, float:1.47118E-40)
            if (r3 == r4) goto L_0x00c2
            r4 = 112675(0x1b823, float:1.57891E-40)
            if (r3 == r4) goto L_0x00b9
            r4 = 120609(0x1d721, float:1.69009E-40)
            if (r3 == r4) goto L_0x00b0
            goto L_0x00d4
        L_0x00b0:
            java.lang.String r3 = "zip"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00d4
            goto L_0x00d3
        L_0x00b9:
            java.lang.String r3 = "rar"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00d4
            goto L_0x00d3
        L_0x00c2:
            java.lang.String r3 = "jar"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00d4
            goto L_0x00d3
        L_0x00cb:
            java.lang.String r3 = "7z"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00d4
        L_0x00d3:
            goto L_0x008f
        L_0x00d4:
            if (r1 == 0) goto L_0x00d9
            r6 = r1
            r1 = 0
            goto L_0x00ec
        L_0x00d9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "/*"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r6 = r1
            r1 = -1
        L_0x00ec:
            r11 = 1
            goto L_0x0197
        L_0x00ef:
            java.lang.String r0 = r4.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = g.g0.d.k.a(r1, r0)
            if (r0 == 0) goto L_0x014a
            r1 = -1
            android.content.ContentResolver r0 = r27.getContentResolver()     // Catch:{ Exception -> 0x011c }
            java.lang.String r3 = "r"
            android.content.res.AssetFileDescriptor r3 = r0.openAssetFileDescriptor(r4, r3)     // Catch:{ Exception -> 0x011c }
            if (r3 == 0) goto L_0x0120
            long r16 = r3.getLength()     // Catch:{ all -> 0x0113 }
            com.lcg.i0.c.a(r3, r11)     // Catch:{ Exception -> 0x011c }
            r1 = r16
            goto L_0x0120
        L_0x0113:
            r0 = move-exception
            r5 = r0
            throw r5     // Catch:{ all -> 0x0116 }
        L_0x0116:
            r0 = move-exception
            r7 = r0
            com.lcg.i0.c.a(r3, r5)     // Catch:{ Exception -> 0x011c }
            throw r7     // Catch:{ Exception -> 0x011c }
        L_0x011c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0120:
            r16 = r1
            android.content.ContentResolver r0 = r27.getContentResolver()
            java.lang.String r1 = "contentResolver"
            g.g0.d.k.d(r0, r1)
            java.lang.String r5 = com.lcg.i0.h.w(r0, r4)
            com.lonelycatgames.Xplore.Browser$e r1 = new com.lonelycatgames.Xplore.Browser$e     // Catch:{ IOException -> 0x0140 }
            r2 = r27
            r3 = r12
            r11 = 1
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x013e }
            r0 = r13
            r1 = 0
            r6 = 1
            goto L_0x0197
        L_0x013e:
            r0 = move-exception
            goto L_0x0142
        L_0x0140:
            r0 = move-exception
            r11 = 1
        L_0x0142:
            java.lang.String r0 = com.lcg.i0.h.H(r0)
            r8.X0(r0)
            goto L_0x0194
        L_0x014a:
            r11 = 1
            goto L_0x0194
        L_0x014c:
            r11 = 1
            java.lang.String r0 = "shortcut"
            java.lang.String r0 = r9.getStringExtra(r0)     // Catch:{ Exception -> 0x018c }
            if (r0 == 0) goto L_0x0181
            java.lang.String r1 = r0.substring(r15, r11)     // Catch:{ Exception -> 0x018c }
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            g.g0.d.k.d(r1, r2)     // Catch:{ Exception -> 0x018c }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x018c }
            if (r1 >= 0) goto L_0x0165
            goto L_0x0175
        L_0x0165:
            if (r11 < r1) goto L_0x0175
            r2 = 2
            java.lang.String r0 = r0.substring(r2)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r2 = "(this as java.lang.String).substring(startIndex)"
            g.g0.d.k.d(r0, r2)     // Catch:{ Exception -> 0x0173 }
            r2 = r0
            goto L_0x0176
        L_0x0173:
            r0 = move-exception
            goto L_0x018e
        L_0x0175:
            r2 = 0
        L_0x0176:
            if (r2 == 0) goto L_0x0192
            com.lonelycatgames.Xplore.App$a r0 = com.lonelycatgames.Xplore.App.f0     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = r0.b(r2)     // Catch:{ Exception -> 0x017f }
            goto L_0x0196
        L_0x017f:
            r0 = move-exception
            goto L_0x018f
        L_0x0181:
            java.lang.String r0 = "goToPath"
            java.lang.String r0 = r9.getStringExtra(r0)     // Catch:{ Exception -> 0x018c }
            if (r0 == 0) goto L_0x0194
            r10.a = r0     // Catch:{ Exception -> 0x018c }
            goto L_0x0194
        L_0x018c:
            r0 = move-exception
            r1 = -1
        L_0x018e:
            r2 = 0
        L_0x018f:
            r0.printStackTrace()
        L_0x0192:
            r0 = r2
            goto L_0x0196
        L_0x0194:
            r0 = 0
            r1 = -1
        L_0x0196:
            r6 = 0
        L_0x0197:
            java.lang.String r2 = "app"
            if (r29 != 0) goto L_0x0274
            android.content.SharedPreferences r3 = r27.A0()
            com.lonelycatgames.Xplore.App r4 = r8.x
            if (r4 == 0) goto L_0x026f
            com.lonelycatgames.Xplore.l r4 = r4.F()
            java.lang.String r5 = "rememberLastPath"
            boolean r3 = r3.getBoolean(r5, r11)
            if (r3 == 0) goto L_0x01b6
            java.lang.String r5 = "activePane"
            int r5 = r4.n(r5, r15)
            goto L_0x01b7
        L_0x01b6:
            r5 = 0
        L_0x01b7:
            r12.B(r5)
            if (r0 != 0) goto L_0x01c2
            T r5 = r10.a
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x01cc
        L_0x01c2:
            if (r1 != r14) goto L_0x01c9
            int r1 = r12.k()
            goto L_0x01cc
        L_0x01c9:
            r12.B(r1)
        L_0x01cc:
            r5 = 0
        L_0x01cd:
            if (r5 > r11) goto L_0x0264
            com.lonelycatgames.Xplore.pane.Pane[] r7 = r12.w()
            r7 = r7[r5]
            r11 = 0
            if (r3 != 0) goto L_0x01db
            r7.p0(r11)
        L_0x01db:
            if (r3 == 0) goto L_0x01f3
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r14 = "pane_path"
            r15.append(r14)
            r15.append(r5)
            java.lang.String r14 = r15.toString()
            java.lang.String r14 = r4.j(r14, r11)
            goto L_0x01f4
        L_0x01f3:
            r14 = 0
        L_0x01f4:
            if (r0 == 0) goto L_0x01fb
            if (r5 != r1) goto L_0x01fb
            r21 = 1
            goto L_0x01fd
        L_0x01fb:
            r21 = 0
        L_0x01fd:
            if (r21 == 0) goto L_0x0207
            if (r0 == 0) goto L_0x0203
            r11 = r0
            goto L_0x0204
        L_0x0203:
            r11 = r13
        L_0x0204:
            r22 = 1
            goto L_0x0216
        L_0x0207:
            T r11 = r10.a
            r15 = r11
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x0213
            if (r5 != r1) goto L_0x0213
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0214
        L_0x0213:
            r11 = r14
        L_0x0214:
            r22 = 0
        L_0x0216:
            if (r11 == 0) goto L_0x0240
            if (r21 == 0) goto L_0x0229
            if (r6 == 0) goto L_0x0229
            if (r9 == 0) goto L_0x0223
            java.lang.String r14 = r28.getType()
            goto L_0x0224
        L_0x0223:
            r14 = 0
        L_0x0224:
            r15 = 0
            r7.G1(r11, r15, r14)
            goto L_0x025d
        L_0x0229:
            r20 = 0
            r23 = 0
            com.lonelycatgames.Xplore.Browser$m r14 = new com.lonelycatgames.Xplore.Browser$m
            r14.<init>(r10, r9)
            r25 = 2
            r26 = 0
            r18 = r7
            r19 = r11
            r24 = r14
            com.lonelycatgames.Xplore.pane.Pane.j2(r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x025d
        L_0x0240:
            com.lonelycatgames.Xplore.x.h r11 = r7.P0()
            java.util.Iterator r11 = r11.iterator()
        L_0x0248:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x025d
            java.lang.Object r14 = r11.next()
            com.lonelycatgames.Xplore.x.m r14 = (com.lonelycatgames.Xplore.x.m) r14
            boolean r15 = r14 instanceof com.lonelycatgames.Xplore.x.g
            if (r15 == 0) goto L_0x0248
            com.lonelycatgames.Xplore.x.g r14 = (com.lonelycatgames.Xplore.x.g) r14
            r7.e2(r14)
        L_0x025d:
            int r5 = r5 + 1
            r11 = 1
            r14 = -1
            r15 = 0
            goto L_0x01cd
        L_0x0264:
            if (r3 != 0) goto L_0x0288
            r3 = -1
            if (r1 != r3) goto L_0x0288
            r1 = 0
            r3 = 1
            r8.f0(r1, r3)
            goto L_0x0288
        L_0x026f:
            g.g0.d.k.q(r2)
            r1 = 0
            throw r1
        L_0x0274:
            r3 = 1
            r1 = 0
        L_0x0276:
            if (r1 > r3) goto L_0x0288
            com.lonelycatgames.Xplore.pane.Pane[] r0 = r12.w()
            r0 = r0[r1]
            com.lonelycatgames.Xplore.x.g r4 = r0.L0()
            r0.e2(r4)
            int r1 = r1 + 1
            goto L_0x0276
        L_0x0288:
            int r0 = r12.k()
            r12.i(r0)
            com.lonelycatgames.Xplore.utils.HorizontalScroll r0 = r8.C
            if (r0 == 0) goto L_0x02dd
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            com.lonelycatgames.Xplore.Browser$n r1 = new com.lonelycatgames.Xplore.Browser$n
            r1.<init>(r8, r12)
            r0.addOnGlobalLayoutListener(r1)
            com.lonelycatgames.Xplore.App r0 = r8.x
            if (r0 == 0) goto L_0x02d8
            com.lonelycatgames.Xplore.ops.copy.a r0 = r0.D()
            if (r0 == 0) goto L_0x02d7
            if (r9 == 0) goto L_0x02cb
            java.lang.String r1 = "showDialog"
            r2 = 0
            boolean r2 = r9.getBooleanExtra(r1, r2)
            if (r2 == 0) goto L_0x02bb
            r9.removeExtra(r1)
            r0.g(r8)
            goto L_0x02d7
        L_0x02bb:
            boolean r1 = r0.Y()
            if (r1 == 0) goto L_0x02d7
            com.lonelycatgames.Xplore.j0 r1 = r0.h()
            if (r1 != 0) goto L_0x02d7
            r0.g(r8)
            goto L_0x02d7
        L_0x02cb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Required value was null."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x02d7:
            return
        L_0x02d8:
            g.g0.d.k.q(r2)
            r1 = 0
            throw r1
        L_0x02dd:
            r1 = 0
            java.lang.String r0 = "horizontalScroll"
            g.g0.d.k.q(r0)
            throw r1
        L_0x02e4:
            r1 = r11
            java.lang.String r0 = "state"
            g.g0.d.k.q(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.I0(android.content.Intent, com.lonelycatgames.Xplore.Browser$f):void");
    }

    private final void J0(Intent intent, com.lonelycatgames.Xplore.x.i iVar) {
        Uri data = intent.getData();
        String scheme = data != null ? data.getScheme() : null;
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return;
                }
            } else if (scheme.equals("http")) {
                return;
            }
        }
        try {
            String type = intent.getType();
            x.a aVar = com.lonelycatgames.Xplore.utils.x.l;
            com.lonelycatgames.Xplore.utils.x a2 = aVar.a(iVar, type, (Long) null, aVar.b());
            App app = this.x;
            if (app != null) {
                app.X0(a2);
                g.g0.d.k.d(intent.setDataAndType(a2.B(), type), "int.setDataAndType(sHttp.uri, mimeType)");
                return;
            }
            g.g0.d.k.q("app");
            throw null;
        } catch (IOException unused) {
            X0("Can't stream file: " + iVar.h0());
        }
    }

    private final void K0() {
        App app = this.x;
        if (app != null) {
            int i2 = 0;
            int o2 = l.o(app.F(), "last_trash_clean_day", 0, 2, (Object) null);
            int i3 = 60;
            App app2 = this.x;
            if (app2 != null) {
                if (!app2.B0() || !Debug.isDebuggerConnected()) {
                    i2 = o2;
                } else {
                    i3 = 5;
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
                if (currentTimeMillis != i2) {
                    g1(i3, currentTimeMillis);
                    return;
                }
                return;
            }
            g.g0.d.k.q("app");
            throw null;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N0(com.lonelycatgames.Xplore.ops.Operation r11, int r12, boolean r13) {
        /*
            r10 = this;
            com.lonelycatgames.Xplore.h r0 = r10.z
            java.lang.String r1 = "state"
            r2 = 0
            if (r0 == 0) goto L_0x00ad
            com.lonelycatgames.Xplore.pane.Pane r5 = r0.j()
            com.lonelycatgames.Xplore.h r0 = r10.z
            if (r0 == 0) goto L_0x00a9
            com.lonelycatgames.Xplore.pane.Pane r6 = r0.q()
            java.util.List r0 = r5.e1()
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            r9 = 0
            if (r0 == 0) goto L_0x0038
            java.util.List r0 = r5.e1()
            boolean r0 = r11.f(r10, r5, r6, r0)
            if (r0 == 0) goto L_0x0036
            java.util.List r7 = r5.l1()
            r3 = r11
            r4 = r10
            r8 = r13
            r3.k(r4, r5, r6, r7, r8)
        L_0x0034:
            r11 = 1
            goto L_0x0051
        L_0x0036:
            r11 = 0
            goto L_0x0051
        L_0x0038:
            com.lonelycatgames.Xplore.x.m r0 = r5.T0()
            if (r0 == 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            com.lonelycatgames.Xplore.x.g r0 = r5.L0()
        L_0x0043:
            r7 = r0
            boolean r0 = r11.e(r10, r5, r6, r7)
            if (r0 == 0) goto L_0x0036
            r3 = r11
            r4 = r10
            r8 = r13
            r3.l(r4, r5, r6, r7, r8)
            goto L_0x0034
        L_0x0051:
            if (r11 == 0) goto L_0x00a6
            com.lonelycatgames.Xplore.App r11 = r10.x
            if (r11 == 0) goto L_0x00a0
            r0 = 2
            g.o[] r0 = new g.o[r0]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            java.lang.String r4 = "item_id"
            g.o r3 = g.u.a(r4, r3)
            r0[r9] = r3
            com.lonelycatgames.Xplore.w$a r3 = com.lonelycatgames.Xplore.w.f10484c
            java.lang.String r3 = r3.b(r12)
            if (r3 == 0) goto L_0x006f
            goto L_0x0085
        L_0x006f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 40
            r3.append(r4)
            r3.append(r12)
            r12 = 41
            r3.append(r12)
            java.lang.String r3 = r3.toString()
        L_0x0085:
            java.lang.String r12 = "item_name"
            g.o r12 = g.u.a(r12, r3)
            r0[r1] = r12
            android.os.Bundle r12 = c.g.m.a.a(r0)
            if (r13 == 0) goto L_0x0098
            java.lang.String r13 = "Alt"
            r12.putBoolean(r13, r1)
        L_0x0098:
            g.y r13 = g.y.a
            java.lang.String r13 = "KeyPress"
            r11.t1(r13, r12)
            goto L_0x00a6
        L_0x00a0:
            java.lang.String r11 = "app"
            g.g0.d.k.q(r11)
            throw r2
        L_0x00a6:
            r10.V = r2
            return
        L_0x00a9:
            g.g0.d.k.q(r1)
            throw r2
        L_0x00ad:
            g.g0.d.k.q(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.N0(com.lonelycatgames.Xplore.ops.Operation, int, boolean):void");
    }

    public static /* synthetic */ void P0(Browser browser, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            browser.O0(z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestButtonBarRefresh");
    }

    private final void R0() {
        App app = this.x;
        if (app != null) {
            App app2 = this.x;
            if (app2 != null) {
                SharedPreferences A0 = A0();
                App app3 = this.x;
                if (app3 != null) {
                    app.S0(new j(app2, A0, app3.F()));
                    App app4 = this.x;
                    if (app4 != null) {
                        app4.O0();
                        finish();
                        startActivity(new Intent(this, getClass()));
                        return;
                    }
                    g.g0.d.k.q("app");
                    throw null;
                }
                g.g0.d.k.q("app");
                throw null;
            }
            g.g0.d.k.q("app");
            throw null;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public static /* synthetic */ void T0(Browser browser, Intent intent, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            browser.S0(intent, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runIntent");
    }

    public static final /* synthetic */ ButtonsBar V(Browser browser) {
        ButtonsBar buttonsBar = browser.F;
        if (buttonsBar != null) {
            return buttonsBar;
        }
        g.g0.d.k.q("buttonsBar");
        throw null;
    }

    public static /* synthetic */ void Z0(Browser browser, CharSequence charSequence, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z2 = true;
            }
            browser.Y0(charSequence, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorToast");
    }

    /* access modifiers changed from: private */
    public final void b1(View view, Object... objArr) {
        PopupMenu popupMenu = new PopupMenu(this, false, new z(this, view), 2, (g) null);
        for (com.lonelycatgames.Xplore.ops.m mVar : objArr) {
            if (mVar instanceof Operation) {
                if (!(mVar == b1.k || mVar == com.lonelycatgames.Xplore.ops.m.m)) {
                    Operation operation = mVar;
                    PopupMenu.i(popupMenu, operation.r(), operation.v(), 0, 4, (Object) null).j(mVar);
                }
            } else if (mVar instanceof g) {
                PopupMenu.i(popupMenu, 0, mVar.b(), 0, 4, (Object) null).j(mVar);
            } else if (mVar instanceof h) {
                h hVar = mVar;
                PopupMenu.i(popupMenu, hVar.a(), hVar.c(), 0, 4, (Object) null).j(mVar);
            } else {
                throw new IllegalArgumentException();
            }
        }
        popupMenu.t(view);
    }

    public static /* synthetic */ void g0(Browser browser, int i2, boolean z2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z2 = true;
            }
            browser.f0(i2, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: activatePane");
    }

    private final u1 g1(int i2, int i3) {
        return h.d(this, z0.a(), (m0) null, new b0(this, i2, i3, (g.d0.d) null), 2, (Object) null);
    }

    private final void h0(Menu menu, Object... objArr) {
        for (g gVar : objArr) {
            if (gVar instanceof g) {
                g gVar2 = gVar;
                SubMenu addSubMenu = menu.addSubMenu(getText(gVar2.b()));
                g.g0.d.k.d(addSubMenu, "sm");
                Object[] a2 = gVar2.a();
                h0(addSubMenu, Arrays.copyOf(a2, a2.length));
            } else if (gVar instanceof Operation) {
                MenuItem menuItem = null;
                if (gVar != b1.k && gVar != com.lonelycatgames.Xplore.ops.m.m) {
                    menuItem = menu.add(((Operation) gVar).v());
                } else if (!((gVar == com.lonelycatgames.Xplore.ops.m.m && !com.lonelycatgames.Xplore.utils.c.l.w()) || K() == null || (menuItem = menu.add(gVar.v())) == null)) {
                    menuItem.setShowAsAction(5);
                }
                if (menuItem != null) {
                    int r2 = gVar.r();
                    if (!(r2 == 0 || menuItem == null)) {
                        menuItem.setIcon(r2);
                    }
                    if (menuItem != null) {
                        menuItem.setOnMenuItemClickListener(new j(this, gVar));
                    }
                }
            } else if (gVar instanceof h) {
                h hVar = (h) gVar;
                MenuItem add = menu.add(hVar.c());
                add.setIcon(hVar.a());
                add.setOnMenuItemClickListener(new i(gVar));
            }
        }
    }

    private final void j0(String str, boolean z2) {
        App app = this.x;
        if (app != null) {
            k kVar = new k(this, z2, str, app, "appStart");
            int i2 = 0;
            if (str != null) {
                i2 = 1;
            }
            int i3 = z2 ? i2 | 2 : i2;
            ViewGroup viewGroup = this.B;
            if (viewGroup != null) {
                com.lcg.i0.h.i0(viewGroup);
                App app2 = this.x;
                if (app2 != null) {
                    j0 n2 = com.lcg.h.n(kVar, app2, this, C0557R.drawable.lock, getString(z2 ? C0557R.string.use_fingerprint : C0557R.string.TXT_ENTER_PASSWORD), i3, (byte[]) null, 32, (Object) null);
                    if (n2 != null) {
                        String string = getString(C0557R.string.password);
                        g.g0.d.k.d(string, "getString(R.string.password)");
                        n2.s(this, string, C0557R.drawable.lock, "app-password");
                        return;
                    }
                    return;
                }
                g.g0.d.k.q("app");
                throw null;
            }
            g.g0.d.k.q("viewRoot");
            throw null;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m0(com.lonelycatgames.Xplore.x.g r13, long r14) {
        /*
            r12 = this;
            com.lonelycatgames.Xplore.FileSystem.h r0 = r13.g0()
            r1 = 0
            r2 = 0
            com.lonelycatgames.Xplore.FileSystem.h$g r11 = new com.lonelycatgames.Xplore.FileSystem.h$g     // Catch:{ e -> 0x00b2 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 30
            r10 = 0
            r3 = r11
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ e -> 0x00b2 }
            com.lonelycatgames.Xplore.x.h r3 = r0.g0(r11)     // Catch:{ e -> 0x00b2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ e -> 0x00b2 }
            r4 = 0
        L_0x001d:
            boolean r5 = r3.hasNext()     // Catch:{ e -> 0x00b0 }
            if (r5 == 0) goto L_0x00ce
            java.lang.Object r5 = r3.next()     // Catch:{ e -> 0x00b0 }
            com.lonelycatgames.Xplore.x.m r5 = (com.lonelycatgames.Xplore.x.m) r5     // Catch:{ e -> 0x00b0 }
            boolean r6 = r5 instanceof com.lonelycatgames.Xplore.x.g     // Catch:{ e -> 0x00b0 }
            if (r6 == 0) goto L_0x003f
            com.lonelycatgames.Xplore.FileSystem.h r6 = r5.g0()     // Catch:{ e -> 0x00b0 }
            boolean r6 = g.g0.d.k.a(r6, r0)     // Catch:{ e -> 0x00b0 }
            if (r6 == 0) goto L_0x003f
            com.lonelycatgames.Xplore.x.g r5 = (com.lonelycatgames.Xplore.x.g) r5     // Catch:{ e -> 0x00b0 }
            int r5 = r12.m0(r5, r14)     // Catch:{ e -> 0x00b0 }
            int r4 = r4 + r5
            goto L_0x001d
        L_0x003f:
            java.lang.String r6 = r5.q0()     // Catch:{ e -> 0x00b0 }
            java.lang.String r7 = ".nomedia"
            boolean r6 = g.g0.d.k.a(r6, r7)     // Catch:{ e -> 0x00b0 }
            if (r6 == 0) goto L_0x004d
            r2 = r5
            goto L_0x001d
        L_0x004d:
            java.lang.String r6 = r5.h0()     // Catch:{ e -> 0x00b0 }
            boolean r7 = r5 instanceof com.lonelycatgames.Xplore.x.s     // Catch:{ e -> 0x00b0 }
            if (r7 == 0) goto L_0x005e
            long r7 = r5.y()     // Catch:{ e -> 0x00b0 }
            int r9 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0074
            goto L_0x001d
        L_0x005e:
            com.lonelycatgames.Xplore.App$a r7 = com.lonelycatgames.Xplore.App.f0     // Catch:{ e -> 0x00b0 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ e -> 0x00b0 }
            r8.<init>()     // Catch:{ e -> 0x00b0 }
            java.lang.String r9 = "Deleting unknown entry in trash: "
            r8.append(r9)     // Catch:{ e -> 0x00b0 }
            r8.append(r6)     // Catch:{ e -> 0x00b0 }
            java.lang.String r8 = r8.toString()     // Catch:{ e -> 0x00b0 }
            r7.q(r8)     // Catch:{ e -> 0x00b0 }
        L_0x0074:
            java.lang.String r7 = "le"
            g.g0.d.k.d(r5, r7)     // Catch:{ e -> 0x00b0 }
            boolean r5 = r0.N(r5, r1)     // Catch:{ e -> 0x00b0 }
            if (r5 == 0) goto L_0x0098
            com.lonelycatgames.Xplore.App$a r5 = com.lonelycatgames.Xplore.App.f0     // Catch:{ e -> 0x00b0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ e -> 0x00b0 }
            r7.<init>()     // Catch:{ e -> 0x00b0 }
            java.lang.String r8 = "Deleted file in trash: "
            r7.append(r8)     // Catch:{ e -> 0x00b0 }
            r7.append(r6)     // Catch:{ e -> 0x00b0 }
            java.lang.String r6 = r7.toString()     // Catch:{ e -> 0x00b0 }
            r5.k(r6)     // Catch:{ e -> 0x00b0 }
            int r4 = r4 + 1
            goto L_0x001d
        L_0x0098:
            com.lonelycatgames.Xplore.App$a r5 = com.lonelycatgames.Xplore.App.f0     // Catch:{ e -> 0x00b0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ e -> 0x00b0 }
            r7.<init>()     // Catch:{ e -> 0x00b0 }
            java.lang.String r8 = "Failed to delete in trash: "
            r7.append(r8)     // Catch:{ e -> 0x00b0 }
            r7.append(r6)     // Catch:{ e -> 0x00b0 }
            java.lang.String r6 = r7.toString()     // Catch:{ e -> 0x00b0 }
            r5.c(r6)     // Catch:{ e -> 0x00b0 }
            goto L_0x001d
        L_0x00b0:
            r14 = move-exception
            goto L_0x00b4
        L_0x00b2:
            r14 = move-exception
            r4 = 0
        L_0x00b4:
            com.lonelycatgames.Xplore.App$a r15 = com.lonelycatgames.Xplore.App.f0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Can't list folder: "
            r3.append(r5)
            java.lang.String r14 = com.lcg.i0.h.H(r14)
            r3.append(r14)
            java.lang.String r14 = r3.toString()
            r15.c(r14)
        L_0x00ce:
            java.lang.String r14 = r13.h0()
            java.io.File r15 = new java.io.File
            r15.<init>(r14)
            java.lang.String[] r3 = r15.list()
            r5 = 1
            if (r2 == 0) goto L_0x00ea
            if (r3 == 0) goto L_0x00ea
            int r6 = r3.length
            if (r6 != r5) goto L_0x00ea
            r0.N(r2, r1)
            java.lang.String[] r3 = r15.list()
        L_0x00ea:
            if (r3 == 0) goto L_0x00f3
            int r15 = r3.length
            if (r15 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r5 = 0
        L_0x00f1:
            if (r5 == 0) goto L_0x0111
        L_0x00f3:
            boolean r13 = r0.N(r13, r1)
            if (r13 == 0) goto L_0x0111
            com.lonelycatgames.Xplore.App$a r13 = com.lonelycatgames.Xplore.App.f0
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "Deleted empty trash folder: "
            r15.append(r0)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.k(r14)
            int r4 = r4 + 1
        L_0x0111:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.m0(com.lonelycatgames.Xplore.x.g, long):int");
    }

    private final int o0() {
        Resources resources = getResources();
        g.g0.d.k.d(resources, "resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        ButtonsBar buttonsBar = this.F;
        if (buttonsBar != null) {
            RecyclerView c2 = buttonsBar.c();
            c2.measure(1000, 1000);
            int measuredWidth = c2.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
            layoutParams.width = measuredWidth;
            g.y yVar = g.y.a;
            c2.setLayoutParams(layoutParams);
            int i3 = this.H;
            if (i3 == 0) {
                return (i2 - measuredWidth) / 2;
            }
            if (i3 != 1) {
                return i2 - measuredWidth;
            }
            return i2 / 2;
        }
        g.g0.d.k.q("buttonsBar");
        throw null;
    }

    private final void q0() {
        u1 unused = h.d(this, (g.d0.g) null, (m0) null, new l(this, (g.d0.d) null), 3, (Object) null);
        App app = this.x;
        if (app != null) {
            app.F().R("demoShown", true);
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final Object[] x0() {
        return new Object[]{com.lonelycatgames.Xplore.ops.m.m, b1.k, com.lonelycatgames.Xplore.ops.i.l, new g(C0557R.string.more, e0.f9567j, com.lonelycatgames.Xplore.ops.g.f9631j, com.lonelycatgames.Xplore.ops.p.f9775j, d0.f9559j, new h(C0557R.drawable.help, C0557R.string.help, new p(this)), new h(C0557R.drawable.tweaks, C0557R.string.tweaks, new q(this))), com.lonelycatgames.Xplore.ops.a.k, com.lonelycatgames.Xplore.ops.o.f9774j};
    }

    public final SharedPreferences A0() {
        App app = this.x;
        if (app != null) {
            return app.e0();
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public final boolean C0() {
        return this.E;
    }

    public final h D0() {
        h hVar = this.z;
        if (hVar != null) {
            return hVar;
        }
        g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        throw null;
    }

    public final g0 E0() {
        g0 g0Var = this.K;
        if (g0Var != null) {
            return g0Var;
        }
        g.g0.d.k.q("thumbnailCache");
        throw null;
    }

    public final com.lonelycatgames.Xplore.o0.a F0() {
        return (com.lonelycatgames.Xplore.o0.a) this.w.getValue();
    }

    public final ViewGroup G0() {
        ViewGroup viewGroup = this.B;
        if (viewGroup != null) {
            return viewGroup;
        }
        g.g0.d.k.q("viewRoot");
        throw null;
    }

    public final void H0() {
        ButtonsBar buttonsBar = this.F;
        if (buttonsBar != null) {
            buttonsBar.d();
        } else {
            g.g0.d.k.q("buttonsBar");
            throw null;
        }
    }

    public final void L0(int i2) {
        App app = this.x;
        if (app != null) {
            int o2 = i2 | app.z().o();
            if (o2 == 15) {
                long currentTimeMillis = System.currentTimeMillis();
                App app2 = this.x;
                if (app2 == null) {
                    g.g0.d.k.q("app");
                    throw null;
                } else if (currentTimeMillis > app2.z().p() + 604800000) {
                    App app3 = this.x;
                    if (app3 != null) {
                        app3.z().Q(currentTimeMillis);
                        App app4 = this.x;
                        if (app4 != null) {
                            app4.F().P("rating_time", currentTimeMillis);
                            o2 = 0;
                            u1 unused = h.d(this, (g.d0.g) null, (m0) null, new o(this, (g.d0.d) null), 3, (Object) null);
                        } else {
                            g.g0.d.k.q("app");
                            throw null;
                        }
                    } else {
                        g.g0.d.k.q("app");
                        throw null;
                    }
                }
            }
            App app5 = this.x;
            if (app5 == null) {
                g.g0.d.k.q("app");
                throw null;
            } else if (app5.z().o() != o2) {
                App app6 = this.x;
                if (app6 != null) {
                    app6.z().P(o2);
                    App app7 = this.x;
                    if (app7 != null) {
                        app7.F().O("rating_functions", o2);
                    } else {
                        g.g0.d.k.q("app");
                        throw null;
                    }
                } else {
                    g.g0.d.k.q("app");
                    throw null;
                }
            }
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    public final void M0(g.g0.c.l<? super Intent, g.y> lVar) {
        g.g0.d.k.e(lVar, "onChosen");
        this.S = lVar;
        startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType("image/*"), 13);
    }

    public void O0(boolean z2) {
        ButtonsBar buttonsBar = this.F;
        if (buttonsBar != null) {
            buttonsBar.e(z2);
        } else {
            g.g0.d.k.q("buttonsBar");
            throw null;
        }
    }

    public final void Q0() {
        i iVar = this.A;
        if (iVar != null) {
            iVar.t();
        } else {
            g.g0.d.k.q("clipboard");
            throw null;
        }
    }

    public final void S0(Intent intent, String str) {
        g.g0.d.k.e(intent, "int");
        if (intent.getComponent() == null) {
            App app = this.x;
            if (app == null) {
                g.g0.d.k.q("app");
                throw null;
            } else if (app.j0() == null) {
                h hVar = this.z;
                if (hVar == null) {
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                } else if (hVar.r() == null) {
                    intent.addFlags(268435456);
                }
            }
        }
        r0(intent);
        try {
            startActivityForResult(intent, 2);
            String type = intent.getType();
            if (type != null) {
                App app2 = this.x;
                if (app2 != null) {
                    app2.t1("view_item", c.g.m.a.a(g.u.a("content_type", type)));
                    return;
                }
                g.g0.d.k.q("app");
                throw null;
            }
        } catch (Exception unused) {
            intent.setDataAndType(intent.getData(), "*/*");
            try {
                startActivity(Intent.createChooser(intent, (CharSequence) null));
            } catch (Exception e2) {
                e2.printStackTrace();
                X0("No Activity found to open file: " + str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r0.K() != false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void U0(com.lonelycatgames.Xplore.pane.Pane r8, android.content.Intent r9, com.lonelycatgames.Xplore.x.i r10) {
        /*
            r7 = this;
            java.lang.String r0 = "pane"
            g.g0.d.k.e(r8, r0)
            java.lang.String r0 = "int"
            g.g0.d.k.e(r9, r0)
            java.lang.String r0 = "fe"
            g.g0.d.k.e(r10, r0)
            android.content.ComponentName r0 = r9.getComponent()
            r1 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.String r2 = r0.getClassName()
            goto L_0x001c
        L_0x001b:
            r2 = r1
        L_0x001c:
            r3 = 1
            java.lang.String r4 = "app"
            if (r0 == 0) goto L_0x0070
            java.lang.Class<com.lonelycatgames.Xplore.ImgViewer.ImageViewer> r0 = com.lonelycatgames.Xplore.ImgViewer.ImageViewer.class
            java.lang.String r0 = r0.getName()
            boolean r0 = g.g0.d.k.a(r2, r0)
            if (r0 == 0) goto L_0x0038
            boolean r0 = r10 instanceof com.lonelycatgames.Xplore.x.k
            if (r0 == 0) goto L_0x0070
            r0 = r10
            com.lonelycatgames.Xplore.x.k r0 = (com.lonelycatgames.Xplore.x.k) r0
            r0.u1(r8)
            goto L_0x0070
        L_0x0038:
            java.lang.Class<com.lonelycatgames.Xplore.Music.MusicPlayerUi> r8 = com.lonelycatgames.Xplore.Music.MusicPlayerUi.class
            java.lang.String r8 = r8.getName()
            boolean r8 = g.g0.d.k.a(r2, r8)
            if (r8 == 0) goto L_0x0070
            com.lonelycatgames.Xplore.App r8 = r7.x
            if (r8 == 0) goto L_0x006c
            java.util.List r0 = g.a0.o.b(r10)
            r5 = 0
            r6 = 2
            com.lonelycatgames.Xplore.App.v0(r8, r0, r5, r6, r1)
            com.lonelycatgames.Xplore.App r8 = r7.x
            if (r8 == 0) goto L_0x0068
            r8.w0()
            java.lang.String r8 = "connect_to_player"
            r9.putExtra(r8, r3)
            r7.invalidateOptionsMenu()
            android.widget.Button r8 = r7.G
            if (r8 == 0) goto L_0x0070
            com.lcg.i0.h.l0(r8)
            goto L_0x0070
        L_0x0068:
            g.g0.d.k.q(r4)
            throw r1
        L_0x006c:
            g.g0.d.k.q(r4)
            throw r1
        L_0x0070:
            com.lonelycatgames.Xplore.App r8 = r7.x
            if (r8 == 0) goto L_0x0150
            r8.k()
            com.lonelycatgames.Xplore.App r8 = r7.x
            if (r8 == 0) goto L_0x014c
            com.lonelycatgames.Xplore.ImgViewer.a r8 = r8.j0()
            if (r8 != 0) goto L_0x0144
            com.lonelycatgames.Xplore.FileSystem.h r8 = r10.g0()
            boolean r8 = r8 instanceof com.lonelycatgames.Xplore.FileSystem.c
            if (r8 == 0) goto L_0x0098
            com.lonelycatgames.Xplore.App r0 = r7.x
            if (r0 == 0) goto L_0x0094
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0106
            goto L_0x0098
        L_0x0094:
            g.g0.d.k.q(r4)
            throw r1
        L_0x0098:
            java.lang.Class<com.lonelycatgames.Xplore.SmartMovie> r0 = com.lonelycatgames.Xplore.SmartMovie.class
            java.lang.String r0 = r0.getName()
            boolean r0 = g.g0.d.k.a(r2, r0)
            if (r0 != 0) goto L_0x00f5
            java.lang.Class<com.lonelycatgames.Xplore.Music.MusicPlayerUi> r0 = com.lonelycatgames.Xplore.Music.MusicPlayerUi.class
            java.lang.String r0 = r0.getName()
            boolean r0 = g.g0.d.k.a(r2, r0)
            if (r0 == 0) goto L_0x00b1
            goto L_0x00f5
        L_0x00b1:
            boolean r0 = r10.c1()
            if (r0 == 0) goto L_0x00bb
            r7.J0(r9, r10)
            goto L_0x0106
        L_0x00bb:
            com.lonelycatgames.Xplore.App r0 = r7.x
            if (r0 == 0) goto L_0x00f1
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x00c7
            if (r8 != 0) goto L_0x00cd
        L_0x00c7:
            boolean r8 = r10.J0()
            if (r8 == 0) goto L_0x00e6
        L_0x00cd:
            java.lang.String r8 = r9.getScheme()
            java.lang.String r0 = "content"
            boolean r8 = g.g0.d.k.a(r8, r0)
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x0106
            android.net.Uri r8 = r10.Y()
            java.lang.String r0 = r9.getType()
            r9.setDataAndType(r8, r0)
            goto L_0x0106
        L_0x00e6:
            com.lonelycatgames.Xplore.ops.m0$a r8 = new com.lonelycatgames.Xplore.ops.m0$a
            com.lonelycatgames.Xplore.Browser$x r0 = new com.lonelycatgames.Xplore.Browser$x
            r0.<init>(r7)
            r8.<init>(r7, r9, r10, r0)
            return
        L_0x00f1:
            g.g0.d.k.q(r4)
            throw r1
        L_0x00f5:
            android.net.Uri r8 = r10.Y()
            java.lang.String r0 = r9.getType()
            android.content.Intent r8 = r9.setDataAndType(r8, r0)
            java.lang.String r0 = "int.setDataAndType(fe.contentUri, int.type)"
            g.g0.d.k.d(r8, r0)
        L_0x0106:
            java.lang.String r8 = r10.p0()
            if (r8 == 0) goto L_0x0110
            java.lang.String r1 = com.lcg.m.b(r8)
        L_0x0110:
            if (r1 != 0) goto L_0x0113
            goto L_0x0144
        L_0x0113:
            int r8 = r1.hashCode()
            r0 = 3556653(0x36452d, float:4.983932E-39)
            if (r8 == r0) goto L_0x011d
            goto L_0x0144
        L_0x011d:
            java.lang.String r8 = "text"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0144
            java.lang.String r8 = "com.lonelycatgames.Xplore.contentUri"
            boolean r0 = r9.hasExtra(r8)
            if (r0 != 0) goto L_0x0144
            com.lonelycatgames.Xplore.x.g r0 = r10.w0()
            if (r0 == 0) goto L_0x0144
            com.lonelycatgames.Xplore.FileSystem.h r1 = r0.g0()
            boolean r0 = r1.l(r0)
            if (r0 == 0) goto L_0x0144
            android.net.Uri r0 = r10.Y()
            r9.putExtra(r8, r0)
        L_0x0144:
            java.lang.String r8 = r10.h0()
            r7.S0(r9, r8)
            return
        L_0x014c:
            g.g0.d.k.q(r4)
            throw r1
        L_0x0150:
            g.g0.d.k.q(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.U0(com.lonelycatgames.Xplore.pane.Pane, android.content.Intent, com.lonelycatgames.Xplore.x.i):void");
    }

    public final void V0(h.c cVar) {
        g.g0.d.k.e(cVar, "tf");
        n0(false);
        h hVar = this.z;
        if (hVar != null) {
            hVar.D(cVar);
            cVar.h();
            return;
        }
        g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        throw null;
    }

    public final void W0(int i2, int i3, String str) {
        g.g0.d.k.e(str, "reason");
        this.T = true;
        App app = this.x;
        if (app != null) {
            app.e1(this, i2, i3, str).setOnDismissListener(new y(this));
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    public final void X0(CharSequence charSequence) {
        g.g0.d.k.e(charSequence, "err");
        ViewGroup viewGroup = this.B;
        if (viewGroup != null) {
            Snackbar W2 = Snackbar.W(viewGroup, charSequence, 0);
            W2.Y(-65536);
            W2.M();
            return;
        }
        g.g0.d.k.q("viewRoot");
        throw null;
    }

    public final void Y0(CharSequence charSequence, boolean z2) {
        g.g0.d.k.e(charSequence, "err");
        App.f0.m(this, charSequence, z2);
    }

    public final void a1(Exception exc) {
        g.g0.d.k.e(exc, "e");
        X0(com.lcg.i0.h.H(exc));
    }

    public final void c1(int i2) {
        App app = this.x;
        if (app != null) {
            App.i1(app, i2, false, 2, (Object) null);
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    public final void d1(CharSequence charSequence) {
        g.g0.d.k.e(charSequence, "s");
        App app = this.x;
        if (app != null) {
            App.j1(app, charSequence, false, 2, (Object) null);
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    public final void e1(Intent intent, g.g0.c.p<? super Boolean, ? super Intent, g.y> pVar) {
        g.g0.d.k.e(intent, "int");
        g.g0.d.k.e(pVar, "receiver");
        this.R = pVar;
        startActivityForResult(intent, 17);
    }

    public final void f0(int i2, boolean z2) {
        h hVar = this.z;
        if (hVar != null) {
            boolean z3 = hVar.k() != i2;
            h hVar2 = this.z;
            if (hVar2 != null) {
                hVar2.g(i2);
                P0(this, false, 1, (Object) null);
                if (z2) {
                    HorizontalScroll horizontalScroll = this.C;
                    if (horizontalScroll != null) {
                        horizontalScroll.smoothScrollTo(i2 == 0 ? 0 : HwBuildEx.VersionCodes.CUR_DEVELOPMENT, 0);
                    } else {
                        g.g0.d.k.q("horizontalScroll");
                        throw null;
                    }
                }
                if (z3) {
                    i iVar = this.A;
                    if (iVar != null) {
                        iVar.r();
                    } else {
                        g.g0.d.k.q("clipboard");
                        throw null;
                    }
                }
            } else {
                g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                throw null;
            }
        } else {
            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            throw null;
        }
    }

    public final void f1() {
        h hVar = this.z;
        if (hVar != null) {
            g0(this, 1 - hVar.k(), false, 2, (Object) null);
        } else {
            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            throw null;
        }
    }

    public final void h1() {
        invalidateOptionsMenu();
    }

    public final void i0(com.lonelycatgames.Xplore.FileSystem.m mVar, Intent intent) {
        g.g0.d.k.e(mVar, "pFs");
        g.g0.d.k.e(intent, "int");
        try {
            startActivityForResult(intent, 8);
            this.Q = mVar;
        } catch (ActivityNotFoundException e2) {
            a1(e2);
        }
    }

    public void j() {
        invalidateOptionsMenu();
        Button button = this.G;
        if (button != null) {
            com.lcg.i0.h.h0(button);
        }
    }

    public boolean k0(com.lonelycatgames.Xplore.x.m mVar) {
        g.g0.d.k.e(mVar, "le");
        return true;
    }

    public g.d0.g l() {
        return this.Y.l();
    }

    /* access modifiers changed from: protected */
    public boolean l0(Operation operation) {
        g.g0.d.k.e(operation, "op");
        return true;
    }

    public final void n0(boolean z2) {
        h hVar = this.z;
        if (hVar != null) {
            h.c r2 = hVar.r();
            if (r2 != null) {
                if (!z2 || !r2.g()) {
                    r2.delete();
                } else {
                    new m0.b(this, r2);
                }
                h hVar2 = this.z;
                if (hVar2 != null) {
                    hVar2.D((h.c) null);
                } else {
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                }
            }
        } else {
            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r0 != null) goto L_0x00e2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r21, int r22, android.content.Intent r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            r2 = r23
            r3 = 0
            r4 = -1
            r5 = 1
            if (r0 != r4) goto L_0x000d
            r6 = 1
            goto L_0x000e
        L_0x000d:
            r6 = 0
        L_0x000e:
            java.lang.String r7 = "Required value was null."
            java.lang.String r8 = "state"
            java.lang.String r9 = "app"
            r10 = 0
            switch(r21) {
                case 1: goto L_0x01a1;
                case 2: goto L_0x0195;
                case 3: goto L_0x0018;
                case 4: goto L_0x016e;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0018;
                case 8: goto L_0x011b;
                case 9: goto L_0x0018;
                case 10: goto L_0x0018;
                case 11: goto L_0x00f1;
                case 12: goto L_0x0080;
                case 13: goto L_0x006e;
                case 14: goto L_0x0018;
                case 15: goto L_0x0059;
                case 16: goto L_0x0038;
                case 17: goto L_0x001d;
                default: goto L_0x0018;
            }
        L_0x0018:
            super.onActivityResult(r21, r22, r23)
            goto L_0x01ab
        L_0x001d:
            g.g0.c.p<? super java.lang.Boolean, ? super android.content.Intent, g.y> r6 = r1.R
            if (r6 == 0) goto L_0x002f
            r1.R = r10
            if (r0 != r4) goto L_0x0026
            r3 = 1
        L_0x0026:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            r6.l(r0, r2)
            goto L_0x01ab
        L_0x002f:
            com.lonelycatgames.Xplore.App$a r0 = com.lonelycatgames.Xplore.App.f0
            java.lang.String r2 = "Received result, but there is no active receiver"
            r0.q(r2)
            goto L_0x01ab
        L_0x0038:
            if (r6 == 0) goto L_0x0052
            if (r2 == 0) goto L_0x0052
            com.lonelycatgames.Xplore.h r0 = r1.z     // Catch:{ Exception -> 0x004c }
            if (r0 == 0) goto L_0x0048
            com.lonelycatgames.Xplore.pane.Pane r0 = r0.j()     // Catch:{ Exception -> 0x004c }
            r0.x1(r2)     // Catch:{ Exception -> 0x004c }
            return
        L_0x0048:
            g.g0.d.k.q(r8)     // Catch:{ Exception -> 0x004c }
            throw r10
        L_0x004c:
            r0 = move-exception
            java.lang.String r0 = com.lcg.i0.h.H(r0)
            goto L_0x0054
        L_0x0052:
            java.lang.String r0 = "Failed login to Huawei account"
        L_0x0054:
            r1.d1(r0)
            goto L_0x01ab
        L_0x0059:
            if (r6 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.ops.i1.c r0 = com.lonelycatgames.Xplore.ops.i1.c.l
            com.lonelycatgames.Xplore.h r2 = r1.z
            if (r2 == 0) goto L_0x006a
            com.lonelycatgames.Xplore.pane.Pane r2 = r2.j()
            r0.J(r1, r2)
            goto L_0x01ab
        L_0x006a:
            g.g0.d.k.q(r8)
            throw r10
        L_0x006e:
            if (r6 == 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            g.g0.c.l<? super android.content.Intent, g.y> r0 = r1.S
            if (r0 == 0) goto L_0x007c
            java.lang.Object r0 = r0.o(r2)
            g.y r0 = (g.y) r0
        L_0x007c:
            r1.S = r10
            goto L_0x01ab
        L_0x0080:
            if (r0 == r4) goto L_0x0098
            if (r0 == 0) goto L_0x0096
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown result: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x00e2
        L_0x0096:
            r0 = r10
            goto L_0x00e2
        L_0x0098:
            if (r2 == 0) goto L_0x00e0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Data: "
            r0.append(r3)
            android.net.Uri r3 = r23.getData()
            r0.append(r3)
            java.lang.String r3 = "\nExtras: "
            r0.append(r3)
            android.os.Bundle r2 = r23.getExtras()
            if (r2 == 0) goto L_0x00d5
            java.util.Set r11 = r2.keySet()
            java.lang.String r3 = "keySet()"
            g.g0.d.k.d(r11, r3)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.lonelycatgames.Xplore.Browser$r r3 = new com.lonelycatgames.Xplore.Browser$r
            r3.<init>(r2)
            r18 = 31
            r19 = 0
            r17 = r3
            java.lang.String r2 = g.a0.x.I(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x00d6
        L_0x00d5:
            r2 = r10
        L_0x00d6:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            java.lang.String r0 = "No intent returned"
        L_0x00e2:
            if (r0 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.App r2 = r1.x
            if (r2 == 0) goto L_0x00ed
            r2.h1(r0, r5)
            goto L_0x01ab
        L_0x00ed:
            g.g0.d.k.q(r9)
            throw r10
        L_0x00f1:
            if (r6 == 0) goto L_0x0114
            if (r2 == 0) goto L_0x0114
            java.lang.String r0 = "authAccount"
            java.lang.String r0 = r2.getStringExtra(r0)
            if (r0 == 0) goto L_0x0113
            java.lang.String r2 = "data.getStringExtra(Acco…Y_ACCOUNT_NAME) ?: return"
            g.g0.d.k.d(r0, r2)
            com.lonelycatgames.Xplore.h r2 = r1.z
            if (r2 == 0) goto L_0x010f
            com.lonelycatgames.Xplore.pane.Pane r2 = r2.j()
            r2.w1(r0)
            goto L_0x01ab
        L_0x010f:
            g.g0.d.k.q(r8)
            throw r10
        L_0x0113:
            return
        L_0x0114:
            java.lang.String r0 = "Failed to choose Google account"
            r1.d1(r0)
            goto L_0x01ab
        L_0x011b:
            com.lonelycatgames.Xplore.FileSystem.m r3 = r1.Q
            if (r3 == 0) goto L_0x01ab
            r1.Q = r10
            if (r3 == 0) goto L_0x01ab
            r3.O0(r1, r0, r2)
            goto L_0x01ab
        L_0x0128:
            if (r6 == 0) goto L_0x01ab
            if (r2 == 0) goto L_0x01ab
            android.net.Uri r0 = r23.getData()
            if (r0 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.ops.d0 r0 = com.lonelycatgames.Xplore.ops.d0.f9559j     // Catch:{ IOException -> 0x0149 }
            android.net.Uri r2 = r23.getData()     // Catch:{ IOException -> 0x0149 }
            if (r2 == 0) goto L_0x013f
            r0.I(r1, r2)     // Catch:{ IOException -> 0x0149 }
            goto L_0x01ab
        L_0x013f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x0149 }
            java.lang.String r2 = r7.toString()     // Catch:{ IOException -> 0x0149 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0149 }
            throw r0     // Catch:{ IOException -> 0x0149 }
        L_0x0149:
            r0 = move-exception
            r1.a1(r0)
            goto L_0x01ab
        L_0x014e:
            if (r6 == 0) goto L_0x01ab
            if (r2 == 0) goto L_0x01ab
            android.net.Uri r0 = r23.getData()
            if (r0 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.ops.p r0 = com.lonelycatgames.Xplore.ops.p.f9775j
            android.net.Uri r2 = r23.getData()
            if (r2 == 0) goto L_0x0164
            r0.I(r1, r2)
            goto L_0x01ab
        L_0x0164:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r7.toString()
            r0.<init>(r2)
            throw r0
        L_0x016e:
            if (r6 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.App r0 = r1.x
            if (r0 == 0) goto L_0x0191
            boolean r0 = r0.F0()
            if (r0 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.App r0 = r1.x
            if (r0 == 0) goto L_0x018d
            r0.p1()
            com.lonelycatgames.Xplore.App r0 = r1.x
            if (r0 == 0) goto L_0x0189
            com.lonelycatgames.Xplore.App.n1(r0, r3, r5, r10)
            goto L_0x01ab
        L_0x0189:
            g.g0.d.k.q(r9)
            throw r10
        L_0x018d:
            g.g0.d.k.q(r9)
            throw r10
        L_0x0191:
            g.g0.d.k.q(r9)
            throw r10
        L_0x0195:
            com.lonelycatgames.Xplore.App r0 = r1.x
            if (r0 == 0) goto L_0x019d
            r0.a1(r10)
            goto L_0x01ab
        L_0x019d:
            g.g0.d.k.q(r9)
            throw r10
        L_0x01a1:
            if (r6 == 0) goto L_0x01ab
            com.lonelycatgames.Xplore.FileSystem.b$a r0 = com.lonelycatgames.Xplore.FileSystem.b.f7314i
            r0.b()
            r20.R0()
        L_0x01ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lonelycatgames.Xplore.Browser.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onBackPressed() {
        h hVar = this.z;
        if (hVar != null) {
            Pane j2 = hVar.j();
            if (j2.N0().g()) {
                j2.N0().f();
                return;
            }
            h hVar2 = this.z;
            if (hVar2 == null) {
                g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                throw null;
            } else if (hVar2.q().N0().g()) {
                h hVar3 = this.z;
                if (hVar3 != null) {
                    hVar3.q().N0().f();
                } else {
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                }
            } else {
                i iVar = this.A;
                if (iVar == null) {
                    g.g0.d.k.q("clipboard");
                    throw null;
                } else if (iVar.n()) {
                    i iVar2 = this.A;
                    if (iVar2 != null) {
                        iVar2.t();
                    } else {
                        g.g0.d.k.q("clipboard");
                        throw null;
                    }
                } else if (!j2.b1().isEmpty()) {
                    j2.m0();
                } else {
                    App app = this.x;
                    if (app == null) {
                        g.g0.d.k.q("app");
                        throw null;
                    } else if (!app.z().f() || (!g.g0.d.k.a(getClass(), Browser.class))) {
                        App app2 = this.x;
                        if (app2 != null) {
                            app2.N0();
                            super.onBackPressed();
                            return;
                        }
                        g.g0.d.k.q("app");
                        throw null;
                    } else if (this.O != null) {
                        try {
                            App app3 = this.x;
                            if (app3 != null) {
                                app3.N0();
                                super.onBackPressed();
                                return;
                            }
                            g.g0.d.k.q("app");
                            throw null;
                        } catch (IllegalStateException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        this.O = h.d(this, (g.d0.g) null, (kotlinx.coroutines.m0) null, new s((g.d0.d) null, this), 3, (Object) null);
                    }
                }
            }
        } else {
            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i2;
        h hVar;
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.lonelycatgames.Xplore.App");
        this.x = (App) application;
        App.f0.k("X-plore start");
        App app = this.x;
        if (app != null) {
            app.p0(this, true);
            m.a aVar = m.l;
            App app2 = this.x;
            if (app2 != null) {
                aVar.b(app2);
                SharedPreferences A0 = A0();
                App app3 = this.x;
                if (app3 != null) {
                    boolean A02 = app3.A0();
                    setTheme(A02 ? C0557R.style.BrowserTheme : 2131820769);
                    super.onCreate(bundle);
                    App app4 = this.x;
                    if (app4 != null) {
                        Object systemService = app4.getSystemService("notification");
                        if (!(systemService instanceof NotificationManager)) {
                            systemService = null;
                        }
                        NotificationManager notificationManager = (NotificationManager) systemService;
                        if (notificationManager != null) {
                            notificationManager.cancel(1);
                            g.y yVar = g.y.a;
                        }
                        if (A0.getBoolean(getString(C0557R.string.cfg_fullscreen), false)) {
                            getWindow().setFlags(1024, 1024);
                        }
                        App app5 = this.x;
                        if (app5 != null) {
                            Object systemService2 = app5.getSystemService("audio");
                            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
                            this.y = (AudioManager) systemService2;
                            float[] fArr = Z;
                            int[] iArr = new int[fArr.length];
                            try {
                                int v2 = com.lcg.i0.h.v(this, A02 ? C0557R.color.theme_base_color_dark : C0557R.color.theme_base_color_light);
                                m a2 = aVar.a();
                                if (a2 != null) {
                                    int c2 = A02 ? a2.c() : a2.d();
                                    if (c2 != 0) {
                                        v2 = c2;
                                    }
                                    g.y yVar2 = g.y.a;
                                }
                                float[] fArr2 = new float[3];
                                Color.colorToHSV(v2, fArr2);
                                float f2 = fArr2[2];
                                int length = fArr.length;
                                int i3 = 0;
                                while (i3 < length) {
                                    boolean z2 = (!A02 || i3 == 2 || i3 == 5) ? false : true;
                                    float f3 = (z2 ? ((float) 1) - f2 : f2) * Z[i3];
                                    if (z2) {
                                        f3 = ((float) 1) - f3;
                                    }
                                    fArr2[2] = f3;
                                    iArr[i3] = Color.HSVToColor(fArr2);
                                    i3++;
                                }
                                Window window = getWindow();
                                g.g0.d.k.d(window, "window");
                                window.setStatusBarColor(iArr[5]);
                                View inflate = getLayoutInflater().inflate(C0557R.layout.browser, (ViewGroup) null);
                                if (inflate != null) {
                                    ViewGroup viewGroup = (ViewGroup) inflate;
                                    this.B = viewGroup;
                                    if (viewGroup != null) {
                                        setContentView((View) viewGroup);
                                        ViewGroup viewGroup2 = this.B;
                                        if (viewGroup2 != null) {
                                            viewGroup2.setBackgroundColor(iArr[0]);
                                            App app6 = this.x;
                                            if (app6 != null) {
                                                this.E = !app6.E0() && getResources().getBoolean(C0557R.bool.show_toolbar);
                                                Toolbar toolbar = (Toolbar) findViewById(C0557R.id.toolbar);
                                                if (!this.E) {
                                                    g.g0.d.k.d(toolbar, "toolbar");
                                                    com.lcg.i0.h.h0(toolbar);
                                                } else {
                                                    R(toolbar);
                                                }
                                                androidx.appcompat.app.a K2 = K();
                                                if (K2 != null) {
                                                    K2.t(12);
                                                }
                                                Resources resources = getResources();
                                                App app7 = this.x;
                                                if (app7 != null) {
                                                    l F2 = app7.F();
                                                    g.g0.d.k.d(resources, "res");
                                                    Integer valueOf = Integer.valueOf(F2.n(resources.getConfiguration().orientation == 2 ? "layout_landscape" : "layout_portrait", 3));
                                                    if (!(valueOf.intValue() != 3)) {
                                                        valueOf = null;
                                                    }
                                                    if (valueOf != null) {
                                                        i2 = valueOf.intValue();
                                                    } else {
                                                        i2 = resources.getInteger(C0557R.integer.pane_scroll_mode);
                                                    }
                                                    this.H = i2;
                                                    View findViewById = findViewById(C0557R.id.info_bar);
                                                    g.g0.d.k.d(findViewById, "findViewById(R.id.info_bar)");
                                                    this.D = findViewById;
                                                    if (findViewById != null) {
                                                        findViewById.setBackgroundColor(iArr[2]);
                                                        View findViewById2 = findViewById(C0557R.id.browser_layout);
                                                        g.g0.d.k.d(findViewById2, "findViewById(R.id.browser_layout)");
                                                        HorizontalScroll horizontalScroll = (HorizontalScroll) findViewById2;
                                                        this.C = horizontalScroll;
                                                        if (horizontalScroll != null) {
                                                            horizontalScroll.setBrowser(this);
                                                            View findViewById3 = findViewById(C0557R.id.mini_toolbar);
                                                            if (!this.E) {
                                                                findViewById3.setBackgroundColor(iArr[1]);
                                                                findViewById3.findViewById(C0557R.id.menu).setOnClickListener(new v(this));
                                                                Button button = (Button) findViewById3.findViewById(C0557R.id.music);
                                                                button.setOnClickListener(new t(this));
                                                                App app8 = this.x;
                                                                if (app8 != null) {
                                                                    if (app8.Z() == null) {
                                                                        com.lcg.i0.h.h0(button);
                                                                    }
                                                                    g.y yVar3 = g.y.a;
                                                                    this.G = button;
                                                                } else {
                                                                    g.g0.d.k.q("app");
                                                                    throw null;
                                                                }
                                                            } else {
                                                                HorizontalScroll horizontalScroll2 = this.C;
                                                                if (horizontalScroll2 != null) {
                                                                    ((ViewGroup) horizontalScroll2.findViewById(C0557R.id.middle_bar)).removeView(findViewById3);
                                                                } else {
                                                                    g.g0.d.k.q("horizontalScroll");
                                                                    throw null;
                                                                }
                                                            }
                                                            View findViewById4 = findViewById(C0557R.id.hack_indicator);
                                                            App app9 = this.x;
                                                            if (app9 != null) {
                                                                int c3 = app9.t().c("ZkjB/cn+SUKN1gc2eLE/DA");
                                                                int i4 = c3 >>> 24;
                                                                for (int i5 = 0; i5 < 5; i5++) {
                                                                    i4 |= Integer.rotateLeft(i4, 1 << i5);
                                                                    g.y yVar4 = g.y.a;
                                                                }
                                                                findViewById4.setBackgroundColor((c3 & 16777215) | (i4 & 1056964608));
                                                                g.y yVar5 = g.y.a;
                                                                App app10 = this.x;
                                                                if (app10 == null) {
                                                                    g.g0.d.k.q("app");
                                                                    throw null;
                                                                } else if (app10 != null) {
                                                                    y X2 = app10.X();
                                                                    HorizontalScroll horizontalScroll3 = this.C;
                                                                    if (horizontalScroll3 != null) {
                                                                        this.K = new g0(app10, X2, horizontalScroll3);
                                                                        App app11 = this.x;
                                                                        if (app11 != null) {
                                                                            g0 g0Var = this.K;
                                                                            if (g0Var != null) {
                                                                                com.lonelycatgames.Xplore.x.n nVar = r1;
                                                                                com.lonelycatgames.Xplore.x.n nVar2 = new com.lonelycatgames.Xplore.x.n(app11, this, g0Var, iArr[3], iArr[4], iArr[0]);
                                                                                this.L = nVar;
                                                                                View view = this.D;
                                                                                if (view != null) {
                                                                                    view.setOnClickListener(new u(this));
                                                                                    Object y2 = y();
                                                                                    if (!(y2 instanceof f)) {
                                                                                        y2 = null;
                                                                                    }
                                                                                    f fVar = (f) y2;
                                                                                    if (fVar == null || (hVar = fVar.a()) == null) {
                                                                                        App app12 = this.x;
                                                                                        if (app12 != null) {
                                                                                            com.lonelycatgames.Xplore.ops.copy.a D2 = app12.D();
                                                                                            hVar = D2 != null ? D2.j() : null;
                                                                                        } else {
                                                                                            g.g0.d.k.q("app");
                                                                                            throw null;
                                                                                        }
                                                                                    }
                                                                                    if (hVar == null) {
                                                                                        App app13 = this.x;
                                                                                        if (app13 != null) {
                                                                                            hVar = new h(app13);
                                                                                        } else {
                                                                                            g.g0.d.k.q("app");
                                                                                            throw null;
                                                                                        }
                                                                                    }
                                                                                    this.z = hVar;
                                                                                    if (hVar != null) {
                                                                                        hVar.x(this);
                                                                                        ViewGroup viewGroup3 = this.B;
                                                                                        if (viewGroup3 != null) {
                                                                                            this.A = new i(this, viewGroup3);
                                                                                            View findViewById5 = findViewById(C0557R.id.button_bar);
                                                                                            g.g0.d.k.d(findViewById5, "findViewById(R.id.button_bar)");
                                                                                            ButtonsBar buttonsBar = new ButtonsBar(this, (RecyclerView) findViewById5);
                                                                                            this.F = buttonsBar;
                                                                                            buttonsBar.c().setBackgroundColor(iArr[1]);
                                                                                            h hVar2 = this.z;
                                                                                            if (hVar2 != null) {
                                                                                                Pane[] w2 = hVar2.w();
                                                                                                int length2 = w2.length;
                                                                                                int i6 = 0;
                                                                                                int i7 = 0;
                                                                                                while (i6 < length2) {
                                                                                                    Pane pane = w2[i6];
                                                                                                    int i8 = i7 + 1;
                                                                                                    View findViewById6 = findViewById(i7 == 0 ? C0557R.id.left : C0557R.id.right);
                                                                                                    g.g0.d.k.d(findViewById6, "findViewById(if(i == 0) R.id.left else R.id.right)");
                                                                                                    pane.o1(this, (ViewGroup) findViewById6);
                                                                                                    i6++;
                                                                                                    i7 = i8;
                                                                                                }
                                                                                                this.I = o0();
                                                                                                h hVar3 = this.z;
                                                                                                if (hVar3 != null) {
                                                                                                    for (Pane E0 : hVar3.w()) {
                                                                                                        E0.E0();
                                                                                                    }
                                                                                                    I0(getIntent(), fVar);
                                                                                                    App app14 = this.x;
                                                                                                    if (app14 != null) {
                                                                                                        app14.a0().add(this);
                                                                                                        K0();
                                                                                                        App app15 = this.x;
                                                                                                        if (app15 != null) {
                                                                                                            boolean D3 = app15.z().D();
                                                                                                            if (D3) {
                                                                                                                App app16 = this.x;
                                                                                                                if (app16 == null) {
                                                                                                                    g.g0.d.k.q("app");
                                                                                                                    throw null;
                                                                                                                } else if (!new com.lcg.h(app16, "appStart").h()) {
                                                                                                                    D3 = false;
                                                                                                                }
                                                                                                            }
                                                                                                            String b2 = j.L.b(A0);
                                                                                                            h hVar4 = this.z;
                                                                                                            if (hVar4 != null) {
                                                                                                                com.lonelycatgames.Xplore.ops.e p2 = hVar4.p();
                                                                                                                if (p2 != null) {
                                                                                                                    p2.g(this);
                                                                                                                    g.y yVar6 = g.y.a;
                                                                                                                }
                                                                                                                if (b2 != null || D3) {
                                                                                                                    App app17 = this.x;
                                                                                                                    if (app17 == null) {
                                                                                                                        g.g0.d.k.q("app");
                                                                                                                        throw null;
                                                                                                                    } else if (!app17.z0()) {
                                                                                                                        j0(b2, D3);
                                                                                                                        g.y yVar7 = g.y.a;
                                                                                                                        return;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                                                                                                                    if (fVar == null) {
                                                                                                                        App app18 = this.x;
                                                                                                                        if (app18 == null) {
                                                                                                                            g.g0.d.k.q("app");
                                                                                                                            throw null;
                                                                                                                        } else if (!l.m(app18.F(), "demoShown", false, 2, (Object) null)) {
                                                                                                                            q0();
                                                                                                                        }
                                                                                                                    }
                                                                                                                    g.y yVar72 = g.y.a;
                                                                                                                    return;
                                                                                                                }
                                                                                                                try {
                                                                                                                    requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
                                                                                                                } catch (Exception e2) {
                                                                                                                    a1(e2);
                                                                                                                }
                                                                                                                g.y yVar722 = g.y.a;
                                                                                                                return;
                                                                                                            }
                                                                                                            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                                                                                                            throw null;
                                                                                                        }
                                                                                                        g.g0.d.k.q("app");
                                                                                                        throw null;
                                                                                                    }
                                                                                                    g.g0.d.k.q("app");
                                                                                                    throw null;
                                                                                                }
                                                                                                g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                                                                                                throw null;
                                                                                            }
                                                                                            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                                                                                            throw null;
                                                                                        }
                                                                                        g.g0.d.k.q("viewRoot");
                                                                                        throw null;
                                                                                    }
                                                                                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                                                                                    throw null;
                                                                                }
                                                                                g.g0.d.k.q("infoBar");
                                                                                throw null;
                                                                            }
                                                                            g.g0.d.k.q("thumbnailCache");
                                                                            throw null;
                                                                        }
                                                                        g.g0.d.k.q("app");
                                                                        throw null;
                                                                    }
                                                                    g.g0.d.k.q("horizontalScroll");
                                                                    throw null;
                                                                } else {
                                                                    g.g0.d.k.q("app");
                                                                    throw null;
                                                                }
                                                            } else {
                                                                g.g0.d.k.q("app");
                                                                throw null;
                                                            }
                                                        } else {
                                                            g.g0.d.k.q("horizontalScroll");
                                                            throw null;
                                                        }
                                                    } else {
                                                        g.g0.d.k.q("infoBar");
                                                        throw null;
                                                    }
                                                } else {
                                                    g.g0.d.k.q("app");
                                                    throw null;
                                                }
                                            } else {
                                                g.g0.d.k.q("app");
                                                throw null;
                                            }
                                        } else {
                                            g.g0.d.k.q("viewRoot");
                                            throw null;
                                        }
                                    } else {
                                        g.g0.d.k.q("viewRoot");
                                        throw null;
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                App app19 = this.x;
                                if (app19 != null) {
                                    app19.n(e3, "Browser.onCreate");
                                    App app20 = this.x;
                                    if (app20 != null) {
                                        App.j1(app20, "Startup failed due to system error", false, 2, (Object) null);
                                        finish();
                                        return;
                                    }
                                    g.g0.d.k.q("app");
                                    throw null;
                                }
                                g.g0.d.k.q("app");
                                throw null;
                            }
                        } else {
                            g.g0.d.k.q("app");
                            throw null;
                        }
                    } else {
                        g.g0.d.k.q("app");
                        throw null;
                    }
                } else {
                    g.g0.d.k.q("app");
                    throw null;
                }
            } else {
                g.g0.d.k.q("app");
                throw null;
            }
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        g.g0.d.k.e(menu, "menu");
        App app = this.x;
        if (app != null) {
            if (app.M()) {
                MenuItem add = menu.add(0, C0557R.id.music_player_id, 0, C0557R.string.music);
                add.setIcon(C0557R.drawable.op_music);
                add.setShowAsAction(5);
            }
            Object[] x0 = x0();
            h0(menu, Arrays.copyOf(x0, x0.length));
            return super.onCreateOptionsMenu(menu);
        }
        g.g0.d.k.q("app");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        u1 u1Var = this.O;
        if (u1Var != null) {
            u1.a.a(u1Var, (CancellationException) null, 1, (Object) null);
        }
        App app = this.x;
        if (app != null) {
            app.a0().remove(this);
            h hVar = this.z;
            if (hVar != null) {
                if (hVar != null) {
                    for (Pane u1 : hVar.w()) {
                        u1.u1(isFinishing());
                    }
                } else {
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                }
            }
            App app2 = this.x;
            if (app2 != null) {
                com.lonelycatgames.Xplore.ops.copy.a D2 = app2.D();
                if (D2 != null) {
                    App app3 = this.x;
                    if (app3 != null) {
                        CopyMoveService A2 = app3.A();
                        if (A2 != null) {
                            D2.n((j0) null);
                            Dialog a2 = A2.a();
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            A2.d((Dialog) null);
                        }
                    } else {
                        g.g0.d.k.q("app");
                        throw null;
                    }
                }
                a2.d(l(), (CancellationException) null, 1, (Object) null);
                return;
            }
            g.g0.d.k.q("app");
            throw null;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Operation operation;
        g.g0.d.k.e(keyEvent, "ke");
        if (i2 == 4) {
            com.lcg.i0.h.Y(300, this.X);
        } else if (i2 == 24 || i2 == 25) {
            AudioManager audioManager = this.y;
            if (audioManager == null) {
                g.g0.d.k.q("audioManager");
                throw null;
            } else if (audioManager.isMusicActive()) {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        if (keyEvent.getRepeatCount() == 0) {
            App app = this.x;
            if (app != null) {
                Operation operation2 = app.T().f().get(i2);
                this.V = operation2;
                this.W = operation2 == null ? 0 : i2;
            } else {
                g.g0.d.k.q("app");
                throw null;
            }
        }
        if (this.W != i2) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (keyEvent.isLongPress() && (operation = this.V) != null) {
            N0(operation, i2, true);
        }
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        g.g0.d.k.e(keyEvent, "ke");
        if (i2 == 4) {
            com.lcg.i0.h.e0(this.X);
        } else if (i2 == 24 || i2 == 25) {
            App app = this.x;
            if (app == null) {
                g.g0.d.k.q("app");
                throw null;
            } else if (app.Z() != null) {
                return super.onKeyUp(i2, keyEvent);
            }
        }
        if (this.W == i2) {
            Operation operation = this.V;
            if (operation != null) {
                N0(operation, i2, false);
            }
            this.W = 0;
            return true;
        }
        this.W = 0;
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        g.g0.d.k.e(intent, "int");
        super.onNewIntent(intent);
        I0(intent, (f) null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        g.g0.d.k.e(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == C0557R.id.music_player_id) {
                Intent intent = new Intent(this, MusicPlayerUi.class);
                intent.putExtra("connect_to_player", true);
                startActivity(intent);
            }
        } else if (this.P) {
            App app = this.x;
            if (app != null) {
                app.N0();
                finish();
            } else {
                g.g0.d.k.q("app");
                throw null;
            }
        } else {
            g1 g1Var = g1.k;
            h hVar = this.z;
            if (hVar != null) {
                Pane j2 = hVar.j();
                h hVar2 = this.z;
                if (hVar2 != null) {
                    g1Var.i(this, j2, hVar2.q(), false);
                } else {
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                }
            } else {
                g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                throw null;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        h hVar = this.z;
        if (hVar != null) {
            if (hVar != null) {
                hVar.y();
                h hVar2 = this.z;
                if (hVar2 != null) {
                    for (Pane A1 : hVar2.w()) {
                        A1.A1();
                    }
                    this.N = true;
                } else {
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                }
            } else {
                g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                throw null;
            }
        }
        App app = this.x;
        if (app != null) {
            app.L0(this);
            App app2 = this.x;
            if (app2 != null) {
                app2.Y().c();
                App app3 = this.x;
                if (app3 != null) {
                    app3.O().a();
                    g0 g0Var = this.K;
                    if (g0Var != null) {
                        g0Var.m();
                        FileContentProvider.a aVar = FileContentProvider.f7253e;
                        App app4 = this.x;
                        if (app4 != null) {
                            aVar.a(app4);
                            Dialog dialog = this.J;
                            if (dialog != null) {
                                dialog.dismiss();
                                this.J = null;
                            }
                            App.f0.e().removeCallbacks(this.U);
                            return;
                        }
                        g.g0.d.k.q("app");
                        throw null;
                    }
                    g.g0.d.k.q("thumbnailCache");
                    throw null;
                }
                g.g0.d.k.q("app");
                throw null;
            }
            g.g0.d.k.q("app");
            throw null;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        g.g0.d.k.e(strArr, "permissions");
        g.g0.d.k.e(iArr, "grantResults");
        if ((iArr.length == 0) || i2 != 1) {
            return;
        }
        if (iArr[0] == 0) {
            l.a aVar = com.lonelycatgames.Xplore.FileSystem.l.p;
            App app = this.x;
            if (app != null) {
                aVar.h(app);
                R0();
                return;
            }
            g.g0.d.k.q("app");
            throw null;
        }
        App app2 = this.x;
        if (app2 != null) {
            app2.h1("Internal memory won't be shown. Restart and allow access.", true);
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        App app = this.x;
        if (app != null) {
            app.c1(this);
            invalidateOptionsMenu();
            super.onResume();
            FileContentProvider.a aVar = FileContentProvider.f7253e;
            App app2 = this.x;
            if (app2 != null) {
                aVar.a(app2);
                h hVar = this.z;
                if (hVar == null) {
                    return;
                }
                if (hVar != null) {
                    hVar.z();
                    h hVar2 = this.z;
                    if (hVar2 != null) {
                        for (Pane pane : hVar2.w()) {
                            pane.B1();
                            if (this.N) {
                                pane.U1();
                            }
                        }
                        return;
                    }
                    g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                    throw null;
                }
                g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                throw null;
            }
            g.g0.d.k.q("app");
            throw null;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        App app = this.x;
        if (app != null) {
            App.q0(app, this, false, 2, (Object) null);
            m.a aVar = m.l;
            App app2 = this.x;
            if (app2 != null) {
                aVar.b(app2);
                com.lonelycatgames.Xplore.utils.c.l.t(this);
                App app3 = this.x;
                if (app3 != null) {
                    app3.V0(this);
                    if (this.z != null) {
                        Intent intent = getIntent();
                        if (intent == null || intent.getAction() == null || g.g0.d.k.a(intent.getAction(), "android.intent.action.MAIN")) {
                            n0(true);
                        }
                        h hVar = this.z;
                        if (hVar != null) {
                            hVar.A();
                        } else {
                            g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
                            throw null;
                        }
                    }
                } else {
                    g.g0.d.k.q("app");
                    throw null;
                }
            } else {
                g.g0.d.k.q("app");
                throw null;
            }
        } else {
            g.g0.d.k.q("app");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        com.lonelycatgames.Xplore.utils.c.l.q(this);
        App app = this.x;
        if (app != null) {
            app.j(this);
            if (!isChangingConfigurations()) {
                Q0();
                return;
            }
            return;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public n p0() {
        App app = this.x;
        if (app != null) {
            return new n(app);
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public void q() {
        invalidateOptionsMenu();
        Button button = this.G;
        if (button != null) {
            com.lcg.i0.h.l0(button);
        }
    }

    public final void r0(Intent intent) {
        Uri data;
        g.g0.d.k.e(intent, "int");
        App app = this.x;
        String str = null;
        if (app != null) {
            if (app.K() && intent.getComponent() == null && (data = intent.getData()) != null) {
                g.g0.d.k.d(data, "uri");
                if (com.lcg.i0.h.N(data)) {
                    g.g0.d.k.d(intent.setDataAndType(FileContentProvider.f7253e.b(com.lcg.i0.h.J(data)), intent.getType()), "int.setDataAndType(FileC…i.pathNotNull), int.type)");
                } else {
                    g.y yVar = g.y.a;
                }
            }
            Uri data2 = intent.getData();
            if (data2 != null) {
                str = data2.getScheme();
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 3143036) {
                    if (hashCode != 951530617 || !str.equals("content")) {
                        return;
                    }
                } else if (!str.equals("file")) {
                    return;
                }
                intent.addFlags(1);
                return;
            }
            return;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public final App s0() {
        App app = this.x;
        if (app != null) {
            return app;
        }
        g.g0.d.k.q("app");
        throw null;
    }

    public final void setInfoBar(View view) {
        g.g0.d.k.e(view, "<set-?>");
        this.D = view;
    }

    public final i t0() {
        i iVar = this.A;
        if (iVar != null) {
            return iVar;
        }
        g.g0.d.k.q("clipboard");
        throw null;
    }

    public final HorizontalScroll u0() {
        HorizontalScroll horizontalScroll = this.C;
        if (horizontalScroll != null) {
            return horizontalScroll;
        }
        g.g0.d.k.q("horizontalScroll");
        throw null;
    }

    public final View v0() {
        View view = this.D;
        if (view != null) {
            return view;
        }
        g.g0.d.k.q("infoBar");
        throw null;
    }

    public void w(int i2, Object... objArr) {
        g.g0.d.k.e(objArr, "params");
        h hVar = this.z;
        if (hVar != null) {
            for (Pane w2 : hVar.w()) {
                w2.w(i2, Arrays.copyOf(objArr, objArr.length));
            }
            if (i2 == 3) {
                App.a aVar = App.f0;
                aVar.e().removeCallbacks(this.U);
                aVar.e().postDelayed(this.U, 200);
            }
            if (i2 == 0 || i2 == 1) {
                O0(true);
                return;
            }
            return;
        }
        g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        throw null;
    }

    public final com.lonelycatgames.Xplore.x.n w0() {
        com.lonelycatgames.Xplore.x.n nVar = this.L;
        if (nVar != null) {
            return nVar;
        }
        g.g0.d.k.q("listEntryDrawHelper");
        throw null;
    }

    public final int y0() {
        return this.H;
    }

    public Object z() {
        h hVar = this.z;
        if (hVar == null) {
            return null;
        }
        if (hVar != null) {
            return new f(hVar);
        }
        g.g0.d.k.q(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        throw null;
    }

    public final int z0() {
        return this.I;
    }
}
