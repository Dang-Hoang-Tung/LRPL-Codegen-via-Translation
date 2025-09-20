/**
 * Recursively computes the total size of files within the given directories and their descendants.
 *
 * Starting from the provided list of child directory names, the function looks up each directory
 * in the filesystem, adds the sum of its files' sizes to the running total, and then recurses
 * into its child directories until no more remain.
 *
 * @param filesystem the mutable list of all directories in the filesystem to search within
 * @param children the names of the child directories whose sizes (including nested) are to be summed
 * @param sum the accumulated size of files so far, carried through recursive calls
 * @return the total size of all files contained within the specified directories and their subdirectories
 */