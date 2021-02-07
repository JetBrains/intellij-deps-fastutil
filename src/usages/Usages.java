package usages;

import it.unimi.dsi.fastutil.Hash;
import it.unimi.dsi.fastutil.bytes.ByteArrayList;
import it.unimi.dsi.fastutil.doubles.Double2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.ints.*;
import it.unimi.dsi.fastutil.longs.*;
import it.unimi.dsi.fastutil.objects.*;

public final class Usages {
  public static void main(String[] args) {
    Hash.Strategy<String> strategy = new Hash.Strategy<String>() {
      @Override
      public int hashCode(String o) {
        return 0;
      }

      @Override
      public boolean equals(String a, String b) {
        return false;
      }
    };

    new Object2ObjectOpenHashMap<String, String>();
    new Object2IntOpenHashMap<String>();
    new Object2ShortOpenHashMap<String>();
    new Object2LongOpenHashMap<String>();
    new Object2DoubleOpenHashMap<String>();
    new Object2ObjectArrayMap<String, String>();

    new Reference2ObjectOpenHashMap<String, String>();
    new Reference2IntOpenHashMap<String>();
    new Object2FloatOpenHashMap<>();
    new Object2BooleanOpenHashMap<>();
    new Int2IntOpenHashMap();
    new Int2ObjectOpenHashMap<String>();
    new Int2IntRBTreeMap();
    new Int2ObjectRBTreeMap<String>();
    new Int2BooleanOpenHashMap();
    new Int2LongOpenHashMap();
    new Int2DoubleOpenHashMap();
    new Long2ObjectOpenHashMap<String>();
    new Long2LongOpenHashMap();
    new Double2ObjectOpenHashMap<String>();

    new ObjectOpenHashSet<String>();
    new ReferenceOpenHashSet<String>();
    new IntOpenHashSet();
    new IntRBTreeSet();
    new LongOpenHashSet();
    new Long2IntOpenHashMap();

    new ObjectLinkedOpenHashSet<String>();
    new LongLinkedOpenHashSet();
    new IntLinkedOpenHashSet();

    new ObjectLinkedOpenCustomHashSet<>(strategy);
    new ObjectOpenCustomHashSet<>(strategy);

    new Object2ObjectOpenCustomHashMap<>(strategy);
    new Object2IntOpenCustomHashMap<>(strategy);
    new Object2LongOpenCustomHashMap<>(strategy);
    new Object2BooleanOpenCustomHashMap<>(strategy);

    new Object2ObjectLinkedOpenHashMap<String, String>();
    new Reference2ObjectLinkedOpenHashMap<String, String>();
    new Int2ObjectLinkedOpenHashMap<String>();

    new Object2ObjectLinkedOpenCustomHashMap<String, String>(strategy);

    new IntArrayList();
    new LongArrayList();
    new DoubleArrayList();
    new ByteArrayList();

    //noinspection StatementWithEmptyBody
    if (IntLists.EMPTY_LIST != null) {
    };
  }
}
