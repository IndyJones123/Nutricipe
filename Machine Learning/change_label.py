import os

folder_path = "C:/Users/fadel/Downloads/labels/carrot/train"  
replacement_value = 6  

file_list = os.listdir(folder_path)

for file_name in file_list:
    if file_name.endswith(".txt"):
        file_path = os.path.join(folder_path, file_name)

        with open(file_path, 'r') as file:
            lines = file.readlines()

        modified_lines = []
        for line in lines:
            line_parts = line.split()
            if line_parts[0] == '0':
                line_parts[0] = str(replacement_value)
            modified_line = ' '.join(line_parts)
            modified_lines.append(modified_line)

        # Tulis perubahan kembali ke file
        with open(file_path, 'w') as file:
            file.write('\n'.join(modified_lines))
