package com.phantomvk.tango.store;

/**
 * Store input method's height using whatever you want. Such as SharedPrefs, MMKV, and etc.
 */
public abstract class Storage {

    /**
     * Stored input method's height, default is 'Integer.MIN_VALUE'.
     */
    static int sHeight = Integer.MIN_VALUE;

    /**
     * Save input method's height.
     *
     * @param height input method's height to save
     */
    public abstract boolean save(int height);

    /**
     * Get input method's height.
     *
     * @param defaultHeight default height
     * @return height
     */
    public abstract int get(int defaultHeight);

    /**
     * Remove stored input method's height.
     *
     * @return Returns true if the values were successfully removed
     * from persistent storage.
     */
    public abstract boolean remove();
}
