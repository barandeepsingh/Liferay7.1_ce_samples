create index IX_1266AEB1 on Bookmarks_BookmarksEntry (companyId, status);
create index IX_FE582790 on Bookmarks_BookmarksEntry (groupId, folderId, status);
create index IX_A32909F3 on Bookmarks_BookmarksEntry (groupId, status);
create index IX_D6D8884A on Bookmarks_BookmarksEntry (groupId, userId, folderId, status);
create index IX_1F0E2B2D on Bookmarks_BookmarksEntry (groupId, userId, status);
create index IX_5FC6EDF1 on Bookmarks_BookmarksEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_61643CB3 on Bookmarks_BookmarksEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_36C6CEDF on Bookmarks_BookmarksFolder (companyId, status);
create index IX_EAA4A648 on Bookmarks_BookmarksFolder (groupId, parentFolderId, status);
create index IX_3FEB1003 on Bookmarks_BookmarksFolder (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3DEDBB45 on Bookmarks_BookmarksFolder (uuid_[$COLUMN_LENGTH:75$], groupId);