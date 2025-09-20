private fun findDirectoryToDelete(size: Long, entry: FileSystemEntry): FileSystemEntry? {
    if(!entry.isDir || entry.getEntrySize() < size) return null

    var potentialDir: FileSystemEntry? = null
    for(child in entry.children) {
        val potentialChildDir = findDirectoryToDelete(size, child)
        if(potentialChildDir != null) {
            if(potentialDir == null || potentialDir.getEntrySize() > potentialChildDir.getEntrySize()) {
                potentialDir = potentialChildDir
            }
        }
    }
    if(potentialDir != null) {
        return potentialDir
    }
    return entry
}